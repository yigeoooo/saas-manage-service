package com.saas.titan.modules.department.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.modules.department.dto.DepartmentDto;
import com.saas.titan.modules.department.vo.DepartmentInsertVo;
import com.saas.titan.modules.department.vo.DepartmentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.modules.department.dao.DepartmentMasterDao;
import com.saas.titan.modules.department.entity.DepartmentMasterEntity;
import com.saas.titan.modules.department.service.DepartmentMasterService;

import java.util.Locale;

import static com.saas.titan.common.utils.StringUtils.getRandomNum;


@Service("departmentMasterService")
public class DepartmentMasterServiceImpl extends ServiceImpl<DepartmentMasterDao, DepartmentMasterEntity> implements DepartmentMasterService {

    @Autowired
    private DepartmentMasterDao departmentMasterDao;

    @Override
    public Page<DepartmentDto> page(DepartmentVo departmentVo) {
        //分页信息封装
        Page<DepartmentMasterEntity> page = new Page<>();
        page.setCurrent(departmentVo.getPage());
        page.setSize(departmentVo.getSize());
        //条件查询封装
        QueryWrapper<DepartmentMasterEntity> query = getQuery(departmentVo);
        return departmentMasterDao.getPage(page, query);
    }

    @Override
    public void insert(DepartmentInsertVo param) {
        //生成科室编码
        String departmentCode = createDepartmentCode("TITAN" + "-" + param.getKey().toUpperCase(Locale.ROOT)
                        + "-",
                Constant.FUOR);
        //构建实体类对象
        DepartmentMasterEntity entity = DepartmentMasterEntity.from(param, departmentCode);
        departmentMasterDao.insert(entity);
    }

    @Override
    public DepartmentDto getInfoById(String id) {
        DepartmentMasterEntity entity = departmentMasterDao.selectById(id);
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setDepartmentName(entity.getDepartmentName());
        dto.setManager(entity.getManager());
        return dto;
    }

    /**
     * 創建TITAN-CODE
     * @param prefixCode 編號前綴
     * @param codeLength 編碼後面隨機長度
     * @return 客戶登錄編號
     */
    public static String createDepartmentCode(String prefixCode,Integer codeLength){
        //隨機生成登錄編碼後面內容
        String randomSuffixCode = getRandomNum(codeLength);
        return prefixCode + randomSuffixCode;
    }

    /**
     * 分页条件拼接
     * @param param vo接参对象
     * @return QueryWrapper 条件构造器
     */
    public QueryWrapper<DepartmentMasterEntity> getQuery(DepartmentVo param) {
        QueryWrapper<DepartmentMasterEntity> query = new QueryWrapper<>();
        //未删除
        query.eq(Constant.DeleteFlag.COLUM_IS_DELETED, Constant.DeleteFlag.NOT_DELETED);
        //条件拼接
        if (StringUtils.isNotBlank(param.getDepartmentCode())) {
            query.eq(TableField.DepartmentMaster.DEPARTMENT_CODE, param.getDepartmentCode());
        }
        if (StringUtils.isNotBlank(param.getDepartmentName())) {
            query.eq(TableField.DepartmentMaster.DEPARTMENT_NAME, param.getDepartmentName());
        }
        return query;
    }
}
