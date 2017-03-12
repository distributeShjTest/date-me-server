package com.date.me.business.read.dao.impl;

import com.date.me.business.read.dao.RelationReadDao;
import com.date.me.model.po.Relation;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shj on 17-3-9.
 */
@Repository
public class RelationReadDaoImpl implements RelationReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMap;
    public List<Relation> queryForRelationById(Integer id) throws Exception {
        return sqlMap.queryForList("relation_sql_map.query_for_relation_by_id",id);
    }
}
