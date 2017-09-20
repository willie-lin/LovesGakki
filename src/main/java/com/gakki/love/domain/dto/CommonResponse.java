package com.gakki.love.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/18
 * \* Time: 23:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
@AllArgsConstructor
public class CommonResponse {

    private boolean result;
    private String message;
}