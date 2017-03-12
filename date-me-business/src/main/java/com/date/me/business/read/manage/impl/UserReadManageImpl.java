package com.date.me.business.read.manage.impl;

import com.date.me.business.read.dao.UserReadDao;
import com.date.me.business.read.manage.UserReadManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shj on 17-3-10.
 */
@Service
public class UserReadManageImpl implements UserReadManage {
    @Autowired
    private UserReadDao userReadDao;

    public Integer getId(String username, String pwd) throws Exception {
        return userReadDao.queryForId(username,pwd);
    }
}
