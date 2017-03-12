package com.date.me.api.net;

import com.date.me.api.net.socket.SocketLisner;

/**
 * Created by shj on 17-3-9.
 */
public interface SocketCallback {
    public void callBack(SocketLisner socketLisner);
    public void msgCallBack(String str,int id,boolean isNullId);

}
