package com.saas.titan.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.utils.IPUtils;
import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.common.utils.StringUtils;
import com.saas.titan.modules.ip.dao.IpContentDao;
import com.saas.titan.modules.ip.dao.IpMasterDao;
import com.saas.titan.modules.ip.entity.IpContentEntity;
import com.saas.titan.modules.ip.entity.IpMasterEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author yigeoooo
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private IpMasterDao ipMasterDao;

    @Autowired
    private IpContentDao ipContentDao;

    /**
     * ..表示包及子包 該方法代表controller層的所有方法
     */
    @Pointcut("execution(public * com.saas.titan.modules.*.controller.*.*(..))")
    public void controllerMethod() {
    }

    /**
     * 方法執行前
     *
     * @param joinPoint
     * @throws Exception
     */
    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
        try {
            MDC.put("TRACE_ID", StringUtils.getUUID());
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();

            StringBuilder requestLog = new StringBuilder();
            Signature signature = joinPoint.getSignature();
            requestLog.append("請求信息：").append("URL = {").append(request.getRequestURI()).append("},\t");
            requestLog.append("請求方式 = {").append(request.getMethod()).append("},\t");
            requestLog.append("請求IP = {").append(IPUtils.getIpAddr(request)).append("},\t");
            requestLog.append("請求SERVER_NAME = {").append(request.getServerName()).append("},\t");
            requestLog.append("請求PORT = {").append(request.getServerPort()).append("}\t");
            //插入ip信息主表与从表
            String hostName = request.getServerName();
            //判断host_name是否存在
            Integer count = ipMasterDao.selectCount(new LambdaQueryWrapper<IpMasterEntity>()
                    .exists("select host_name from ip_master where host_name = '" + hostName + "'"));
            if (count == Constant.ZERO) {
                //不存在插入ip信息
                IpMasterEntity entity = new IpMasterEntity();
                entity.setHostName(hostName);
                entity.setInsertUserId(ShiroUtils.getLoginId());
                ipMasterDao.insert(entity);
            }
            //记录操作记录
            IpContentEntity entity = new IpContentEntity();
            entity.setHostName(hostName);
            entity.setRequestUrl(request.getRequestURI());
            entity.setRequestMethod(request.getMethod());
            entity.setRequestPort(String.valueOf(request.getServerPort()));
            //插入
            ipContentDao.insert(entity);
            // 處理請求參數
            String[] paramNames = ((MethodSignature) signature).getParameterNames();
            Object[] paramValues = joinPoint.getArgs();
            int paramLength = null == paramNames ? 0 : paramNames.length;
            if (paramLength == 0) {
                requestLog.append("請求參數 = {} ");
            } else {
                requestLog.append("請求參數 = [");
                List<Object> args = Arrays.asList(paramValues);
                requestLog.append(args).append("]");
            }

            log.info(requestLog.toString());
        } catch (Exception e){
            log.error("切面日誌輸出失敗！",e);
        }
    }


    /**
     * 方法執行後
     *
     * @param resultInfo
     * @throws Exception
     */
    @AfterReturning(returning = "resultInfo", pointcut = "controllerMethod()")
    public void logResultInfo(Object resultInfo) {
        String js =  JSONObject.toJSONString(resultInfo);
        log.info("請求結果：{}", js);
//        log.info("請求結果：" + JSONObject.parseObject(js));
    }

}
