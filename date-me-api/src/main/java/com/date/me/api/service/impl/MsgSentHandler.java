package com.date.me.api.service.impl;

import com.date.me.api.net.UserMsgSent;
import com.date.me.api.protocol.ProtocolPack;
import com.date.me.api.service.BufferHandle;
import com.date.me.api.service.Handler;
import com.date.me.model.dto.ClientMsg;
import com.date.me.model.dto.JSONAnalyze;
import com.date.me.model.dto.MsgType;
import com.date.me.model.dto.ServerMsg;
import com.date.me.model.po.Massage;

/**
 * Created by shj on 17-3-10.
 */
public class MsgSentHandler extends Handler {
    private BufferHandle bufferHandle;
    private UserMsgSent userMsgSent;
    private ProtocolPack protocolPack;

    public void handle(JSONAnalyze jsonAnalyze,boolean isNullId) {
        if(isNullId){
            this.userMsgSent.sentBack(jsonAnalyze.getId(),this.protocolPack.loginError(),isNullId);
            return;
        }
        if(!jsonAnalyze.getObjectType().equals(this.objectType))
            return;
        if(!(jsonAnalyze.getObject() instanceof ClientMsg))
            return;
        ClientMsg clientMsg = (ClientMsg) jsonAnalyze.getObject();
        if(clientMsg.getMsgtype().equals(MsgType.SHAKE)){
            if(clientMsg.getFrlist().size()>1){
                return;
            }else {
                ServerMsg serverMsg = new ServerMsg();
                serverMsg.setFrid(jsonAnalyze.getId());
                serverMsg.setContent("");
                serverMsg.setMsgtype(MsgType.SHAKE);
                serverMsg.setTime(clientMsg.getTime());
                String str = this.protocolPack.msgSent(serverMsg);
                if(!this.userMsgSent.sentBack(clientMsg.getFrlist().get(0),str,isNullId)){

                    this.bufferHandle.addMassageBuffer(clientMsg.getFrlist().get(0),this.ClientMsgToMassage(serverMsg,jsonAnalyze.getId()));
                    this.userMsgSent.sentBack(jsonAnalyze.getId(),this.protocolPack.msgSentFail(),isNullId);
                }
            }
        }else {
            for(Integer fid:clientMsg.getFrlist()){
                ServerMsg serverMsg = new ServerMsg();
                serverMsg.setFrid(jsonAnalyze.getId());
                serverMsg.setTime(clientMsg.getTime());
                serverMsg.setMsgtype(MsgType.MSG);
                serverMsg.setContent(clientMsg.getContent());
                if(!this.userMsgSent.sentBack(fid,this.protocolPack.msgSent(serverMsg),isNullId)){
                    this.bufferHandle.addMassageBuffer(fid,this.ClientMsgToMassage(serverMsg,jsonAnalyze.getId()));
                    this.userMsgSent.sentBack(serverMsg.getFrid(),this.protocolPack.msgSentFail(),isNullId);
                }
            }
        }
    }

    private Massage ClientMsgToMassage(ServerMsg serverMsg,int id){
        Massage massage = new Massage();
        massage.setTime(serverMsg.getTime());
        massage.setContent(serverMsg.getContent());
        massage.setIsBuffer(1);
        massage.setIsDelete(0);
        massage.setMsgType(MsgType.SHAKE.getValue());
        massage.setRecieveId(serverMsg.getFrid());
        massage.setSendId(id);
        return massage;
    }

    public BufferHandle getBufferHandle() {
        return bufferHandle;
    }

    public void setBufferHandle(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
    }

    public UserMsgSent getUserMsgSent() {
        return userMsgSent;
    }

    public void setUserMsgSent(UserMsgSent userMsgSent) {
        this.userMsgSent = userMsgSent;
    }

    public ProtocolPack getProtocolPack() {
        return protocolPack;
    }

    public void setProtocolPack(ProtocolPack protocolPack) {
        this.protocolPack = protocolPack;
    }
}
