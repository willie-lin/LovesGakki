package com.gakki.love.controller.user;

import com.gakki.love.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/18
 * \* Time: 22:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Slf4j
@Controller
public class UserController {
    @Resource
    private UserService userService;

    /*
    个人中心
     */


}