package com.date.me.business.read.manage.impl;

import com.date.me.business.read.dao.MassageReadDao;
import com.date.me.business.read.manage.MassageReadManage;
import com.date.me.model.dto.ServerMsg;
import com.date.me.model.po.Massage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
@Service
public class MassageReadManageImpl implements MassageReadManage {
    @Autowired
    private MassageReadDao massageReadDao;

    public List<Massage> getBufferMsg(Integer id) throws Exception {
        return this.massageReadDao.queryBufferMsg(id);
    }
}
