package com.date.me.api.service;

/**
 * Created by shj on 17-3-11.
 */
public interface MsgRecieveFromNet {
    void recieve(String str,int id,boolean isNullId) throws Exception;
}
