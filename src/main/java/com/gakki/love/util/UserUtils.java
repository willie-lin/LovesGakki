package com.gakki.love.util;

import com.gakki.love.constant.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpSession;
/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/16
 * \* Time: 2:18
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Slf4j
public class UserUtils {


    //默认成功信息
    private static final String SUCCESS_MESSAGE = MessageConstant.SUCCESS_MESSAGE;


    public static void execSuccess(HttpSession session,String... succMessage){

        if (succMessage.length > 0){
            session.setAttribute("succMessage", succMessage[0]);
            return;
        }
        session.setAttribute("succMessage",SUCCESS_MESSAGE);
    }

    /*
    检测用户是否登录
     */

    public static boolean checkLogin(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ " principal : { }", principal);

        if (principal.equals("anonymousUser")){
            return false;
        }

        org.springframework.security.core.userdetails.User user = (User) principal;
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ " principal : { }" + user.getUsername());
        return true;
    }
}