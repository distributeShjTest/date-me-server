package com.date.me.api.protocol;

import com.date.me.api.protocol.impl.ProtocolAnalyze;
import com.date.me.business.read.dao.MassageReadDao;
import com.date.me.model.dto.MsgType;
import com.date.me.model.dto.PidClientType;
import com.date.me.model.dto.ProtocolType;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by shj on 17-3-11.
 */
public class ProtocolAnalyzeTestCase extends TestCase {

    private ProtocolAnalyze protocolAnalyze;



    public ProtocolAnalyzeTestCase() {

        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-api/spring-service.xml");
        this.protocolAnalyze = (ProtocolAnalyze) applicationContext.getBean("protocolAnalyze");

    }

    public void testAnalyze(){
        JSONObject loginObject = new JSONObject();
        loginObject.put(ProtocolType.PID.getValue(), PidClientType.LOGIN.getPID());
        loginObject.put(ProtocolType.USERNAME.getValue(),"shj");
        loginObject.put(ProtocolType.PWD.getValue(),"123456");



        JSONObject updateObject = new JSONObject();
//        System.out.println(PidClientType.MAGSENT.getPID());
        updateObject.put(ProtocolType.PID.getValue(),PidClientType.UPDATE.getPID());

        JSONObject msgObject = new JSONObject();
        msgObject.put(ProtocolType.PID.getValue(),PidClientType.MAGSENT.getPID());
        JSONArray jsonArray = new JSONArray();
        JSONObject fr_1 = new JSONObject();
        JSONObject fr_2 = new JSONObject();
        fr_1.put(ProtocolType.ID.getValue(),"2");
        fr_2.put(ProtocolType.ID.getValue(),"3");
        jsonArray.put(fr_1);
        jsonArray.put(fr_2);
        msgObject.put(ProtocolType.FRLIST.getValue(),jsonArray);
        msgObject.put(ProtocolType.TIME.getValue(),(new Date()).getTime());
        msgObject.put(ProtocolType.MSGTYPE.getValue(), MsgType.MSG.getValue());
        msgObject.put(ProtocolType.CONTENT.getValue(),"hello");

        System.out.println(loginObject);
        System.out.println(updateObject);
        System.out.println(msgObject);

        int id = 5;
        try {
            System.out.println(this.protocolAnalyze.analyzePro(loginObject.toString(),id));
            System.out.println(this.protocolAnalyze.analyzePro(updateObject.toString(),id));
            System.out.println(this.protocolAnalyze.analyzePro(msgObject.toString(),id));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();

        }
    }



}
