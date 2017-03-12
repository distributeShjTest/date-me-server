package com.date.me.api.protocol;

import com.date.me.api.protocol.impl.ProtocolAnalyze;
import com.date.me.model.dto.Friend;
import com.date.me.model.po.Massage;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shj on 17-3-11.
 */
public class ProtocolPacageTestcase extends TestCase {
    private ProtocolPack protocolPack;
    public ProtocolPacageTestcase(){
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:date-me-api/spring-service.xml");
        this.protocolPack = (ProtocolPack) applicationContext.getBean("protocolPack");

    }

    public void testLoginError(){
        System.out.println(this.protocolPack.loginError());
    }
    public void  testMsgSent(){
        Massage massage = new Massage();
        massage.setSendId(1);
        massage.setRecieveId(2);
        massage.setContent("hello");
        massage.setMsgType(1);
        massage.setIsDelete(0);
        massage.setTime((new Date()).getTime());
        massage.setIsBuffer(1);
        massage.setId(5);
        System.out.println(this.protocolPack.msgSent(massage));
    }
    public void testMsgSentFail(){
        System.out.println(this.protocolPack.msgSentFail());
    }
    public void testFrientList(){
        List<Friend> frList = new ArrayList<Friend>();
        Friend f_1 = new Friend();
        f_1.setId(1);
        f_1.setName("shj");
        Friend f_6 = new Friend();
        f_6.setId(5);
        f_6.setName("dongzhao84");
        frList.add(f_1);
        frList.add(f_6);
        int id = 1;
        System.out.println(this.protocolPack.frientList(frList,id));;
    }

}
