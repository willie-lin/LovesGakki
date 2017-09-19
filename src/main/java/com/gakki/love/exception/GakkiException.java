package com.gakki.love.exception;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/16
 * \* Time: 1:22
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class GakkiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public GakkiException(String message){

        super(message);
    }
    public GakkiException(){
        
    }
}
