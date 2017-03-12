package com.date.me.api.service.impl;

import com.date.me.business.write.manage.MassageWriteManage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shj on 17-3-11.
 */
public class UpdateWriteThread extends Thread {
    @Autowired
    private MassageWriteManage massageWriteManage;
    private List<Integer> updateBufferMsg;
    @Override
    public void run() {
        try {
            if(this.updateBufferMsg!=null){
                this.massageWriteManage.updateIsBufferById(this.updateBufferMsg);
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

    public List<Integer> getUpdateBufferMsg() {
        return updateBufferMsg;
    }

    public void setUpdateBufferMsg(List<Integer> updateBufferMsg) {
        this.updateBufferMsg = updateBufferMsg;
    }
}
