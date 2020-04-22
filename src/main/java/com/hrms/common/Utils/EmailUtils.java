package com.hrms.common.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailUtils {
    @Value("${email.username}")
    private String emailName;
    @Value("${email.tail}")
    private String tail;
    @Value("${email.IMAP.auth}")
    private String auth;
    @Autowired
    CAPTCHAUtils captchaUtils;

    /**
     * 发送验证码
     *
     * @param email
     * @return
     */
    public boolean sendCAPTCHA(String email) {
        try {
            String CAPTCHA = captchaUtils.generateCAPTCHA(email);
            String subject = "您的验证码";
            String content = "您好，您的验证码是：" + CAPTCHA;
            return sendEmail(email, subject, content);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 发送邮件的通用方法
     *
     * @param email
     * @param subject
     * @param content
     * @return
     */
    public boolean sendEmail(String email, String subject, String content) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.qq.com");
            properties.put("mail.smtp.auth", "true");
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailName, auth);
                }
            };
            Session session = Session.getInstance(properties, authenticator);
            Message mailMessage = new MimeMessage(session);
            Address from = new InternetAddress(emailName + tail);
            Address to = new InternetAddress(email);
            mailMessage.setFrom(from);
            mailMessage.addRecipient(Message.RecipientType.TO, to);
            mailMessage.setSubject(subject);//设置邮件标题
            mailMessage.setText(content);
            Transport.send(mailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
