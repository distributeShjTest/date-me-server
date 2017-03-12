package com.date.me.business.read.dao;

import com.date.me.model.po.Relation;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by shj on 17-3-9.
 */
public class RelationReadDaoTestCase extends TestCase{
    private RelationReadDao relationReadDao;

    public RelationReadDaoTestCase(){
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-business/spring-service.xml");
        this.relationReadDao = (RelationReadDao) applicationContext.getBean("relationReadDaoImpl");
    }
    public void testQueryForRelationById(){
        try {
            List<Relation> relations = this.relationReadDao.queryForRelationById(1);
            System.out.println(relations);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
