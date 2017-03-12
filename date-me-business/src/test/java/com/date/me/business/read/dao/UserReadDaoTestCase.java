package com.date.me.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 17-3-9.
 */
public class UserReadDaoTestCase extends TestCase {
    private UserReadDao userReadDao;
    public UserReadDaoTestCase(){
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-business/spring-service.xml");
        userReadDao = (UserReadDao)applicationContext.getBean("userReadDaoImpl");
    }
    public void testQueryForId(){
        try {
            System.out.println(this.userReadDao.queryForId("dongzhao84","123456"));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }


}
