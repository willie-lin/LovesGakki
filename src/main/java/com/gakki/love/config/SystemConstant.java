package com.gakki.love.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/15
 * \* Time: 0:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
@Data
public class SystemConstant {
    @Value("${gakki.encrypt.strength}")
    private int encryptStrength;
}