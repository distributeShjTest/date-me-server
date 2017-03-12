package com.date.me.api.service;

import com.date.me.model.dto.JSONAnalyze;
import com.date.me.model.dto.ObjectType;

/**
 * Created by shj on 17-3-10.
 */
public abstract class Handler {
    protected ObjectType objectType;
    public abstract void handle(JSONAnalyze jsonAnalyze,boolean isNullId) throws Exception;

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
    public boolean equals(ObjectType o){
        return this.objectType.equals(o);
    }
}
