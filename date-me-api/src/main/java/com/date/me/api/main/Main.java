package com.date.me.api.main;

import com.date.me.api.net.socket.SocketHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 17-3-9.
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-api/spring-service.xml");
        SocketHandler socketHandler = (SocketHandler) applicationContext.getBean("socketHandler");
        socketHandler.start();
        System.out.println("server start");
    }
}
