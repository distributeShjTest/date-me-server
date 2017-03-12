package com.date.me.business.write.dao.impl;

import com.date.me.business.read.dao.MassageReadDao;
import com.date.me.business.write.dao.MassageWriteDao;
import com.date.me.model.po.Massage;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shj on 17-3-9.
 */
@Repository
public class MassageWriteDaoImpl implements MassageWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMap;

    public void updateIsBufferById(List<Integer> ids) throws Exception {

    }

    public void insertMassage(List<Massage> massages) throws Exception {

    }
}
