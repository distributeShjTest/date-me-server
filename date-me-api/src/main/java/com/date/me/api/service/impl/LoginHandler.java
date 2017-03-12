package com.date.me.api.service.impl;

import com.date.me.api.common.ObjectUtil;
import com.date.me.api.net.SocketRequestHandler;
import com.date.me.api.net.UserMsgSent;
import com.date.me.api.protocol.ProtocolPack;
import com.date.me.api.service.BufferHandle;
import com.date.me.api.service.Handler;
import com.date.me.business.read.manage.MassageReadManage;
import com.date.me.business.read.manage.RelationReadManage;
import com.date.me.business.read.manage.UserReadManage;
import com.date.me.model.dto.Friend;
import com.date.me.model.dto.JSONAnalyze;
import com.date.me.model.dto.LoginProtocol;
import com.date.me.model.po.Massage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public class LoginHandler extends Handler {
    @Autowired
    private UserReadManage userReadManage;
    @Autowired
    private RelationReadManage relationReadManage;
    @Autowired
    private MassageReadManage massageReadManage;
    private UserMsgSent userMsgSent;
    private ProtocolPack protocolPack;
    private SocketRequestHandler socketRequestHandler;
    private BufferHandle bufferHandle;

    public void handle(JSONAnalyze jsonAnalyze,boolean isNullId) throws Exception {
//        System.out.println(jsonAnalyze);
        System.out.println(jsonAnalyze.getId()+""+isNullId);
        if(!isNullId){
            this.userMsgSent.sentBack(jsonAnalyze.getId(),this.protocolPack.protocalError(),isNullId);
            return;
        }
        if (!(jsonAnalyze.getObject() instanceof LoginProtocol))
            return;
        LoginProtocol loginProtocol = (LoginProtocol)jsonAnalyze.getObject();
        if(ObjectUtil.isEmpty(loginProtocol.getUsername())||ObjectUtil.isEmpty(loginProtocol.getPwd())){
            this.userMsgSent.sentBack(jsonAnalyze.getId(),this.protocolPack.loginError(),isNullId);
            return;
        }
        Integer realId = this.userReadManage.getId(loginProtocol.getUsername(),loginProtocol.getPwd());
        if(ObjectUtil.isEmpty(realId)){
            this.userMsgSent.sentBack(jsonAnalyze.getId(),this.protocolPack.loginError(),isNullId);
            return;
        }

        this.socketRequestHandler.socketThreadHandler(jsonAnalyze.getId(),realId);
        isNullId = false;
        List<Friend> friends = this.relationReadManage.getRelation(realId);
        String frStr = this.protocolPack.frientList(friends,realId);
        this.userMsgSent.sentBack(realId,frStr,isNullId);
        Massage bufferMassage = null;
        while (!ObjectUtil.isEmpty(bufferMassage=this.bufferHandle.getBufferMassage(realId))){
            if(this.userMsgSent.sentBack(realId,this.protocolPack.msgSent(bufferMassage),isNullId)){
                this.bufferHandle.updateBufferMsg(realId);
            }
        }
        List<Massage> bufferMassages = this.massageReadManage.getBufferMsg(realId);
        for (Massage m:bufferMassages){
            if(this.userMsgSent.sentBack(realId,this.protocolPack.msgSent(m),isNullId)){
                    this.bufferHandle.addUpdateBuffer(m.getId());
            }
        }

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

    public SocketRequestHandler getSocketRequestHandler() {
        return socketRequestHandler;
    }

    public void setSocketRequestHandler(SocketRequestHandler socketRequestHandler) {
        this.socketRequestHandler = socketRequestHandler;
    }

    public BufferHandle getBufferHandle() {
        return bufferHandle;
    }

    public void setBufferHandle(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
    }

    public UserReadManage getUserReadManage() {
        return userReadManage;
    }

    public RelationReadManage getRelationReadManage() {
        return relationReadManage;
    }

    public MassageReadManage getMassageReadManage() {
        return massageReadManage;
    }
}
