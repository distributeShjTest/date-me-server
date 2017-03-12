package com.date.me.api.service.impl;

import com.date.me.api.net.UserMsgSent;
import com.date.me.api.protocol.ProtocolPack;
import com.date.me.api.service.Handler;
import com.date.me.business.read.manage.RelationReadManage;
import com.date.me.model.dto.Friend;
import com.date.me.model.dto.JSONAnalyze;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public class UpdateHandler extends Handler {

    @Autowired
    private RelationReadManage relationReadManage;
    private UserMsgSent userMsgSent;
    private ProtocolPack protocolPack;
    private static Logger logger = Logger.getLogger(UpdateHandler.class);
    public void handle(JSONAnalyze jsonAnalyze,boolean isNullId) {
        if(isNullId){
            this.userMsgSent.sentBack(jsonAnalyze.getId(),this.protocolPack.loginError(),isNullId);
            return;
        }
        if(!this.objectType.equals(jsonAnalyze.getObjectType()))
        return;
        try {
            List<Friend> friends =  this.relationReadManage.getRelation(jsonAnalyze.getId());
            this.userMsgSent.sentBack(jsonAnalyze.getId(),this.protocolPack.frientList(friends,jsonAnalyze.getId()),isNullId);

        }catch (Exception e){
            logger.error(e.getMessage());
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

    public RelationReadManage getRelationReadManage() {
        return relationReadManage;
    }

    public void setRelationReadManage(RelationReadManage relationReadManage) {
        this.relationReadManage = relationReadManage;
    }
}
