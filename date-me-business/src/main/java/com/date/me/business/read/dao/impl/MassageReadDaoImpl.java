package com.date.me.business.read.dao.impl;

import com.date.me.business.read.dao.MassageReadDao;
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
public class MassageReadDaoImpl implements MassageReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMap;
    public List<Massage> queryBufferMsg(int id) throws Exception {
        return sqlMap.queryForList("massage_sql_map.query_buffer_msg",id);
    }
}
