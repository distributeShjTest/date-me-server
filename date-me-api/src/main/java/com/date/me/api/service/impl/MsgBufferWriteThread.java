package com.date.me.api.service.impl;

import com.date.me.business.write.manage.MassageWriteManage;
import com.date.me.model.po.Massage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shj on 17-3-11.
 */
public class MsgBufferWriteThread extends Thread {
    @Autowired
    private MassageWriteManage massageWriteManage;
    private List<Massage> bufferMsg;
    private static Logger logger = Logger.getLogger(MsgBufferWriteThread.class);
    @Override
    public void run() {
        try {
            if(this.bufferMsg!=null){
                this.massageWriteManage.insertMassage(this.bufferMsg);
            }
        }catch (Exception e){

        }

    }

    public MassageWriteManage getMassageWriteManage() {
        return massageWriteManage;
    }

    public void setMassageWriteManage(MassageWriteManage massageWriteManage) {
        this.massageWriteManage = massageWriteManage;
    }


    public List<Massage> getBufferMsg() {
        return bufferMsg;
    }

    public void setBufferMsg(List<Massage> bufferMsg) {
        this.bufferMsg = bufferMsg;
    }
}
