package com.date.me.api.protocol.impl;

import com.date.me.api.protocol.AnalyzeAbstact;
import com.date.me.model.dto.JSONAnalyze;
import com.date.me.model.dto.ObjectType;
import org.json.JSONObject;

/**
 * Created by shj on 17-3-10.
 */
public class UpdateAnalyze extends AnalyzeAbstact {
//    private ObjectType objectType = ObjectType.UPDATE;
//    private PidClientType pidClientType = PidClientType.UPDATE;
    public JSONAnalyze analyze(JSONObject JSONObject,int pid,int id) {
//        JSONObject jsonObject = new JSONObject(JSONString);
        JSONAnalyze res = new JSONAnalyze();
        res.setId(id);
        res.setObjectType(ObjectType.UPDATE);
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
