package com.gakki.love.util;

import com.gakki.love.config.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/14
 * \* Time: 0:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
/*
加密类
 */
@Slf4j
@Component
public class EncryptUtil {
    @Resource
    private SystemConstant systemConstant;
    private static BCryptPasswordEncoder encoder;

    /**
     *
     */
    @PostConstruct
    public void initBCryptPasswordEncoder(){
        /*
        加盐
         */
        encoder = new BCryptPasswordEncoder(systemConstant.getEncryptStrength(),new SecureRandom("gakki".getBytes()));

    }

    public static String execEncrypt(Object string) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "  : [{}]", encoder);
        String encode = encoder.encode(string.toString());
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "  加密： [{ }],[{ }]", string, encode);
        return encode;
    }

    public static boolean matchers(String plainPassword,String encodedPassword){

        boolean matches = encoder.matches(plainPassword,encodedPassword);
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName() +" 加密：[{ }]",matches);
        return matches;
    }


}