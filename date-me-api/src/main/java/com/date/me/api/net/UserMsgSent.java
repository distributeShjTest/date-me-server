package com.date.me.api.net;

/**
 * Created by shj on 17-3-10.
 */
public interface UserMsgSent {
//    void sent(Integer userId,String str,boolean isNullId);
    boolean sentBack(Integer userId,String str,boolean isNullId);
//    void loginSent(Integer id,String str);
//    boolean nullIdSentBack(Integer id,String str);
}
