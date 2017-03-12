package com.date.me.api.protocol.impl;

import com.date.me.api.protocol.AnalyzeAbstact;
import com.date.me.api.service.ProtocolSent;
import com.date.me.model.dto.*;
import org.json.JSONException;
import org.json.JSONObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public class ProtocolAnalyze   {
    private List<AnalyzeAbstact> analyzes;



    public List<AnalyzeAbstact> getAnalyzes() {
        return analyzes;
    }

    public void setAnalyzes(List<AnalyzeAbstact> analyzes) {
        this.analyzes = analyzes;
    }

    public JSONAnalyze analyzePro(String JSONString, int id) throws JSONException,Exception{
        JSONObject jsonObject = new JSONObject(JSONString);
        JSONAnalyze res = new JSONAnalyze();
//        System.out.println(jsonObject);
        PidClientType pidClientType = PidClientType.getPidClintType(jsonObject.getInt(ProtocolType.PID.getValue()));
//        if(pidClientType.equals(PidClientType.LOGIN)){
//            LoginProtocol loginProtocol = new LoginProtocol();
//            loginProtocol.setPid(pidClientType.getPID());
//            String username = jsonObject.get(ProtocolType.USERNAME.getValue()).toString();
//            String pwd = jsonObject.getString(ProtocolType.PWD.getValue());
//            loginProtocol.setUsername(username);
//            loginProtocol.setPwd(pwd);
//            res.setObjectType(ObjectType.LOGINPROTOCOL);
//            res.setObject(loginProtocol);
//            this.protocolSent.sent(res);
//        }else if (pidClientType.equals(PidClientType.MAGSENT)){
//            res.setId(id);
//            ClientMsg clientMsg = new ClientMsg();
//            clientMsg.setPid(pidClientType.getPID());
//            clientMsg.setTime(jsonObject.getLong(ProtocolType.TIME.getValue()));
//            clientMsg.setMsgtype(MsgType.getMsgType(jsonObject.getInt(ProtocolType.MSGTYPE.getValue())));
//            clientMsg.setContent(jsonObject.getString(ProtocolType.CONTENT.getValue()));
//            JSONArray jsonArray = jsonObject.getJSONArray(ProtocolType.FRLIST.getValue());
//            List<Integer> frList = new ArrayList<Integer>();
//
//            for(int i=0;i<jsonArray.length();i++){
//                frList.add(jsonArray.getJSONObject(i).getInt(ProtocolType.ID.getValue()));
//            }
//            clientMsg.setFrlist(frList);
//            res.setObject(clientMsg);
//            res.setObjectType(ObjectType.CLientMsg);
//            this.protocolSent.sent(res);
//        }else if(pidClientType.equals(PidClientType.UPDATE)){
//            res.setId(id);
//            res.setObjectType(ObjectType.UPDATE);
//            this.protocolSent.sent(res);
//        }else {
//
//        }
//        System.out.println(pidClientType);

        for(AnalyzeAbstact a:this.analyzes){
            if (a.equals(pidClientType)) {
                return a.analyze(jsonObject,pidClientType.getPID(),id);
            }
        }
        return null;
//        return res;

    }

}
