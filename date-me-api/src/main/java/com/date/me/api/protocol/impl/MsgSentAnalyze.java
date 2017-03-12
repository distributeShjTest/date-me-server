package com.date.me.api.protocol.impl;

import com.date.me.api.protocol.AnalyzeAbstact;
import com.date.me.model.dto.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public class MsgSentAnalyze extends AnalyzeAbstact {
//    private ObjectType objectType=ObjectType.CLientMsg;
//    private PidClientType pidClientType = PidClientType.MAGSENT;
    public JSONAnalyze analyze(JSONObject jsonObject,int pid,int id) {
//        JSONObject jsonObject = new JSONObject(JSONString);
        JSONAnalyze res = new JSONAnalyze();
        res.setId(id);
        ClientMsg clientMsg = new ClientMsg();
        clientMsg.setPid(pid);
        clientMsg.setTime(jsonObject.getLong(ProtocolType.TIME.getValue()));
        clientMsg.setMsgtype(MsgType.getMsgType(jsonObject.getInt(ProtocolType.MSGTYPE.getValue())));
        clientMsg.setContent(jsonObject.getString(ProtocolType.CONTENT.getValue()));
        JSONArray jsonArray = jsonObject.getJSONArray(ProtocolType.FRLIST.getValue());
        List<Integer> frList = new ArrayList<Integer>();

        for(int i=0;i<jsonArray.length();i++){
            frList.add(jsonArray.getJSONObject(i).getInt(ProtocolType.ID.getValue()));
        }
        clientMsg.setFrlist(frList);
        res.setObject(clientMsg);
        res.setObjectType(ObjectType.CLientMsg);
        return res;
    }

//    public ObjectType getObjectType() {
//        return objectType;
//    }
//
//    public void setObjectType(ObjectType objectType) {
//        this.objectType = objectType;
//    }
//
//    public boolean equals(ObjectType o) {
//        return this.objectType.equals(o);
//    }
}
