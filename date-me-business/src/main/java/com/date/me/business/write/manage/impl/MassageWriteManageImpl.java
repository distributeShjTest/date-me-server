package com.date.me.business.write.manage.impl;

import com.date.me.business.write.dao.MassageWriteDao;
import com.date.me.business.write.manage.MassageWriteManage;
import com.date.me.model.po.Massage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
@Service
public class MassageWriteManageImpl implements MassageWriteManage {
    @Autowired
    private MassageWriteDao massageWriteDao;

    public void updateIsBufferById(List<Integer> ids) throws Exception {
        this.massageWriteDao.updateIsBufferById(ids);
    }

    public void insertMassage(List<Massage> massages) throws Exception {
        this.massageWriteDao.insertMassage(massages);
    }
}
