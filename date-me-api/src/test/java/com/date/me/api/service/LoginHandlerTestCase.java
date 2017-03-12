package com.date.me.api.service;

import com.date.me.api.protocol.impl.ProtocolAnalyze;
import com.date.me.api.service.impl.LoginHandler;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 17-3-11.
 */
public class LoginHandlerTestCase extends TestCase{
    private LoginHandler loginHandler;
    public LoginHandlerTestCase(){
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-api/spring-service.xml");
        this.loginHandler = (LoginHandler) applicationContext.getBean("loginHandler");
    }

    public void testLoginHanlerConstructor(){
        System.out.println(this.loginHandler.getMassageReadManage());
        System.out.println(this.loginHandler.getRelationReadManage());
        System.out.println(this.loginHandler.getUserReadManage());

    }


}
