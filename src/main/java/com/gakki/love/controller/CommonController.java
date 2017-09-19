package com.gakki.love.controller;

import com.gakki.love.constant.PageConstant;
import com.gakki.love.domain.Roles;
import com.gakki.love.domain.User;
import com.gakki.love.domain.dto.CommonResponse;
import com.gakki.love.service.UserService;
import com.gakki.love.util.EncryptUtil;
import com.gakki.love.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/18
 * \* Time: 22:59
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Slf4j
@Controller
@SessionAttributes(value = {"user"},types = {User.class})
public class CommonController {
    @Resource
    private UserService userService;

    /**
     * 用户注册或登陆
     *
     */

    @GetMapping("/login")
    public String input(User user, Map<String,Object> map){

        return PageConstant.USER_INPUT;
    }

    public CommonResponse createUser(@Valid User user, BindingResult result){
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ "user:{ }",user);

        if (result.hasErrors()){
            StringBuilder message = new StringBuilder("提交信息错误:").append(PageConstant.BR);

            result.getAllErrors().stream().iterator().forEachRemaining(objectError -> message.append(objectError.getDefaultMessage()).append(PageConstant.BR));
            log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"message: { }" +message.toString());
            return new CommonResponse(false,message.toString());
        }
        user.setEmail(EncryptUtil.execEncrypt(user.getEmail()));
        if (StringUtils.hasChinese(user.getUsername())){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
            user.setAlias(simpleDateFormat.format(new Date()));
        }
        user.setPassword(EncryptUtil.execEncrypt(user.getPassword()));
        List<Roles> roles = new ArrayList<>();
//        Roles userRole = rolesService.getName(user);


        return null;
    }

}