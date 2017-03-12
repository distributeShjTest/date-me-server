package com.date.me.business.read.manage;

/**
 * Created by shj on 17-3-10.
 */
public interface UserReadManage {
    Integer getId(String username,String pwd)throws Exception;
}
