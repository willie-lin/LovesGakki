package com.gakki.love.util;

import org.apache.commons.digester.RegexRules;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/14
 * \* Time: 0:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class IntegerUtil {

    private static final Integer ZERO = 0;

    public static boolean isPositiveValue(Integer integer){
        return integer != null && integer.compareTo(ZERO) >ZERO;
    }

    public static boolean isNegativeValue(Integer integer){
        return integer != null && integer.compareTo(ZERO) < ZERO;

    }


}