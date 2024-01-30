package com.saas.titan.common.utils;


import cn.hutool.extra.mail.MailException;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.pojo.entity.ToEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author yigeoooo
 * @since date 2024/1/30
 */
@Slf4j
@Component
public class MailUtils {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${spring.mail.username}")
    private String from;

    public void commonEmail(ToEmail toEmail) {
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(from);
        //谁要接收
        message.setTo(toEmail.getTos());
        //邮件标题
        message.setSubject(toEmail.getSubject());
        //邮件内容
        message.setText(toEmail.getContent());
        try {
            mailSender.send(message);
//            String code = redisUtils.get(toEmail.getContent().substring(Constant.TEN));
//            if (code == null) {
//                throw new BusinessException("redis缓存错误，未能储存验证码！");
//            }
//            log.info("发送成功,验证码是：{}", code);
        } catch (MailException e) {
            log.error("发送失败！");
        }
    }
}
