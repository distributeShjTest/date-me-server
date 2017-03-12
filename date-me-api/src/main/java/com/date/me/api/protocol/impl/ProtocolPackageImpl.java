package com.date.me.api.protocol.impl;

import com.date.me.api.protocol.ProtocolPack;
import com.date.me.model.dto.*;
import com.date.me.model.po.Massage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public class ProtocolPackageImpl implements ProtocolPack {
    public String loginError() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ProtocolType.PID.getValue(), PidServerType.LOGINERROR.getPid());
        return jsonObject.toString();
    }

    public String msgSent(List<Massage> massages) {
        return null;
    }

    public String msgSent(Massage massage) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ProtocolType.PID.getValue(),PidServerType.MSGSENT.getPid());
        jsonObject.put(ProtocolType.FRID.getValue(),massage.getSendId());
        jsonObject.put(ProtocolType.TIME.getValue(),massage.getTime());
        jsonObject.put(ProtocolType.MSGTYPE.getValue(),massage.getMsgType());
        jsonObject.put(ProtocolType.CONTENT.getValue(),massage.getContent());
        return jsonObject.toString();
    }

    public String msgSent(ServerMsg serverMsg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ProtocolType.PID.getValue(),PidServerType.MSGSENT.getPid());
        jsonObject.put(ProtocolType.FRID.getValue(),serverMsg.getFrid());
        jsonObject.put(serverMsg.getMsgtype().name(),serverMsg.getMsgtype().getValue());
        jsonObject.put(ProtocolType.TIME.getValue(),serverMsg.getTime());
        jsonObject.put(ProtocolType.CONTENT.getValue(),serverMsg.getContent());

        return jsonObject.toString();
    }

    public String msgSentFail() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ProtocolType.PID.getValue(),PidServerType.MAGSENTERROR.getPid());
        return jsonObject.toString();
    }

    public String frientList(List<Friend> frList, Integer id) {
        JSONObject res = new JSONObject();
        res.put(ProtocolType.PID.getValue(),PidServerType.FRLIST.getPid());
        JSONArray jsonArray = new JSONArray();
//        System.out.println(frList);
        for(Friend f:frList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(ProtocolType.ID.getValue(),f.getId());
            jsonObject.put(ProtocolType.NAME.getValue(),f.getName());
            jsonArray.put(jsonObject);
//            System.out.println("array_put");
        }
        res.put(ProtocolType.FRLIST.getValue(),jsonArray);


        return res.toString();
    }



    public String protocalError() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ProtocolType.PID.getValue(),PidServerType.PROTOCOLEROOR.getPid());

        return jsonObject.toString();
    }

    public String connectionSuccess() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ProtocolType.PID.getValue(),PidServerType.CONNECTTIONSUCCESS.getPid());
        return jsonObject.toString();
    }
}
