package com.date.me.api.protocol;

import com.date.me.model.dto.Friend;
import com.date.me.model.dto.ServerMsg;
import com.date.me.model.po.Massage;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public interface ProtocolPack {
    String loginError();
    String msgSent(List<Massage> massages);
    String msgSent(Massage massage);
    String msgSent(ServerMsg serverMsg);
    String msgSentFail();
    String frientList(List<Friend> frList,Integer id);
    String protocalError();
    String connectionSuccess();
}
