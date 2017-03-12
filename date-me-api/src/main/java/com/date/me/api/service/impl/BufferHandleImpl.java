package com.date.me.api.service.impl;

import com.date.me.api.constant.Constant;
import com.date.me.api.service.BufferHandle;
import com.date.me.business.write.manage.MassageWriteManage;
import com.date.me.model.dto.BufferMsg;
import com.date.me.model.po.Massage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public class BufferHandleImpl implements BufferHandle{
    @Autowired
    private MassageWriteManage massageWriteManage;

    private List<Integer> updateBufferMsg;
    private BufferMsg bufferMsg;
//    private MsgBufferWriteThread msgBufferWriteThread;
//    private UpdateWriteThread updateWriteThread;
    private static Logger logger = Logger.getLogger(BufferHandleImpl.class);
    public void init(){
        this.updateBufferMsg = new ArrayList<Integer>();
        this.bufferMsg = new BufferMsg();
    }

    public  void addUpdateBuffer(Integer msgId) {
        synchronized (this.updateBufferMsg){

            try {
                if(this.updateBufferMsg.size()> Constant.BUFFER_CLEAR_NUM){
//                this.updateWriteThread.setUpdateBufferMsg(this.updateBufferMsg);
                    UpdateWriteThread updateWriteThread = new UpdateWriteThread();
                    updateWriteThread.setMassageWriteManage(this.massageWriteManage);
                    updateWriteThread.setUpdateBufferMsg(this.updateBufferMsg);
                    updateWriteThread.start();
                    this.updateBufferMsg = new ArrayList<Integer>();
                    this.updateBufferMsg.add(msgId);
//                this.updateWriteThread.start();
                }

            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }


    }

    public void updateBufferMsg(Integer id,int index){
        this.bufferMsg.updateState(id,index);
    }

    public void updateBufferMsg(Integer id) {
        this.bufferMsg.updateState(id);
    }

    public void addMassageBuffer(Integer id, Massage massage) {

        try {
            synchronized (this.bufferMsg){
                if(this.bufferMsg.addBufferMsg(id,massage)){
                    this.bufferMsg = new BufferMsg();
                    this.bufferMsg.addBufferMsg(id,massage);
                    MsgBufferWriteThread thread = new MsgBufferWriteThread();
                    thread.setBufferMsg(bufferMsg.maptoList());
                    thread.setMassageWriteManage(this.massageWriteManage);
                    thread.start();

                }
            }



        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public Massage getBufferMassage(Integer id) {
        return this.bufferMsg.getFirstMassage(id);
    }
}
