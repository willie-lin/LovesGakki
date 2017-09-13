package com.gakki.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/13
 * \* Time: 1:54
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@ComponentScan("com.gakki.love")
public class LoveGakki extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(LoveGakki.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LoveGakki.class);
    }
}