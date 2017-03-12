package com.date.me.business.read.dao;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 17-3-9.
 */
public class MassageReadDaoTestCase extends TestCase {
    private MassageReadDao massageReadDao;
    public MassageReadDaoTestCase(){
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-business/spring-service.xml");
        this.massageReadDao = (MassageReadDao) applicationContext.getBean("massageReadDaoImpl");
    }
    public void testQueryBufferMsg(){
        try {
            System.out.println(this.massageReadDao.queryBufferMsg(6));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }
}
