package com.date.me.business.read.dao;

import com.date.me.business.write.dao.MassageWriteDao;
import com.date.me.model.po.Massage;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shj on 17-3-9.
 */
public class MassageWriteDaoTestCase extends TestCase {
    private MassageWriteDao massageWriteDao;

    public MassageWriteDaoTestCase(){
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-business/spring-service.xml");
        this.massageWriteDao = (MassageWriteDao) applicationContext.getBean("massageWriteDaoImpl");
    }
    public void testUpdateIsBufferById(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        try {
            this.massageWriteDao.updateIsBufferById(list);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void testInsertMassage(){
        List<Massage> massages = new ArrayList<Massage>();
        Massage massage = new Massage(null,6,(new Date()).getTime(),2,1,"how r u",0,1);
        Massage massage1 = new Massage(null,2,(new Date()).getTime(),6,1,"how r u",0,1);
        massages.add(massage);
        massages.add(massage1);
        try {
            this.massageWriteDao.insertMassage(massages);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
