package com.gakki.love.util;

import com.gakki.love.domain.User;
import com.gakki.love.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/14
 * \* Time: 0:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Slf4j
public class MailUtils {

    /**
     *
     * @param mailTo
     * @param top
     * @param content
     */
    public static void sendMail(String mailTo, String top, String content)
    {

        Properties props = new Properties();

        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        Session session = Session.getInstance(props);

        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("abc@qq.com"));
            InternetAddress to[] = new InternetAddress[1];
            to[0] = new InternetAddress(mailTo);
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject(top);
            message.setContent(content, "text/html;charset=UTF-8");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.qq.com", "abc@qq,com");
            transport.sendMessage(message, to);
            transport.close();

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param email
     * @return
     */

    public static boolean isMail(String email){

        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.+\\w+([-.]\\w)*$");

        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){

            log.debug("邮箱");
            return true;
        }
        return false;
    }



    /**
     * 数据库是否存在?
     * @param email
     * @param userService
     * @return
     */

    public static boolean exist(String email, UserService userService){

        User user = userService.getByEmail(EncryptUtil.execEncrypt(email));
        return user == null ? false :true;
    }

}