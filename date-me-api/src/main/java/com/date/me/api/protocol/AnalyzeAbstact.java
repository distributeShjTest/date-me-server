package com.date.me.api.protocol;

import com.date.me.model.dto.JSONAnalyze;
import com.date.me.model.dto.ObjectType;
import com.date.me.model.dto.PidClientType;
import org.json.JSONObject;

/**
 * Created by shj on 17-3-10.
 */
public abstract class AnalyzeAbstact {
//    private ObjectType objectType;
    private PidClientType pidClientType;
    public abstract JSONAnalyze analyze(JSONObject jsonObject, int pid, int id);
//    public boolean equals(ObjectType o){
//        return this.objectType.equals(o);
//    }
    public boolean equals(PidClientType p){
        return this.pidClientType.equals(p);
    }

//    public ObjectType getObjectType() {
//        return objectType;
//    }
//
//    public void setObjectType(ObjectType objectType) {
//        this.objectType = objectType;
//    }


    public PidClientType getPidClientType() {
        return pidClientType;
    }

    public void setPidClientType(PidClientType pidClientType) {
        this.pidClientType = pidClientType;
    }
}
