package com.date.me.api.protocol.impl;

import com.date.me.api.protocol.AnalyzeAbstact;
import com.date.me.model.dto.*;
import org.json.JSONObject;

/**
 * Created by shj on 17-3-10.
 */
public class LoginAnalyze extends AnalyzeAbstact {
//    private ObjectType objectType=ObjectType.LOGINPROTOCOL;
//    private PidClientType pidClientType=PidClientType.LOGIN;
    public JSONAnalyze analyze(JSONObject jsonObject,int pid,int id) {
//        JSONObject jsonObject = new JSONObject(JSONString);
        JSONAnalyze res = new JSONAnalyze();
        LoginProtocol loginProtocol = new LoginProtocol();
        loginProtocol.setPid(pid);
        String username = jsonObject.get(ProtocolType.USERNAME.getValue()).toString();
        String pwd = jsonObject.getString(ProtocolType.PWD.getValue());
        loginProtocol.setUsername(username);
        loginProtocol.setPwd(pwd);
        res.setObjectType(ObjectType.LOGINPROTOCOL);
        res.setObject(loginProtocol);
        res.setId(id);
        return res;
    }

//    public boolean equals(ObjectType o) {
//        return this.objectType.equals(o);
//    }
//
//    public ObjectType getObjectType() {
//        return objectType;
//    }
//
//    public void setObjectType(ObjectType objectType) {
//        this.objectType = objectType;
//    }
}
