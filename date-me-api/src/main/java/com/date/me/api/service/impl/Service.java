package com.date.me.api.service.impl;

import com.date.me.api.net.UserMsgSent;
import com.date.me.api.protocol.impl.ProtocolAnalyze;
import com.date.me.api.protocol.impl.ProtocolPackageImpl;
import com.date.me.api.service.Handler;
import com.date.me.api.service.MsgRecieveFromNet;
import com.date.me.api.service.ProtocolSent;
import com.date.me.model.dto.JSONAnalyze;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public class Service implements ProtocolSent,MsgRecieveFromNet{
    private ProtocolAnalyze protocolAnalyze;
    private List<Handler> handlers;
    private UserMsgSent userMsgSent;
    private ProtocolPackageImpl protocolPackage;
    public Service() {
    }



    public void sent(JSONAnalyze jsonAnalyze) {

    }

    public void recieve(String str, int id,boolean isNullId) throws Exception{
        JSONAnalyze jsonAnalyze = null;
        try {
            jsonAnalyze =this.protocolAnalyze.analyzePro(str,id);
        }catch (Exception e){
            this.userMsgSent.sentBack(id,this.protocolPackage.protocalError(),isNullId);
            return;
        }


        for(Handler h:handlers){
            if(h.getObjectType().equals(jsonAnalyze.getObjectType())){
                h.handle(jsonAnalyze,isNullId);
            }
        }
    }

    public ProtocolAnalyze getProtocolAnalyze() {
        return protocolAnalyze;
    }

    public void setProtocolAnalyze(ProtocolAnalyze protocolAnalyze) {
        this.protocolAnalyze = protocolAnalyze;
    }

    public List<Handler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<Handler> handlers) {
        this.handlers = handlers;
    }

    public UserMsgSent getUserMsgSent() {
        return userMsgSent;
    }

    public void setUserMsgSent(UserMsgSent userMsgSent) {
        this.userMsgSent = userMsgSent;
    }

    public ProtocolPackageImpl getProtocolPackage() {
        return protocolPackage;
    }

    public void setProtocolPackage(ProtocolPackageImpl protocolPackage) {
        this.protocolPackage = protocolPackage;
    }
}
