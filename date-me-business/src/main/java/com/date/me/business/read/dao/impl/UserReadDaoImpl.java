package com.date.me.business.read.dao.impl;

import com.date.me.business.read.dao.UserReadDao;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shj on 17-3-9.
 */
@Repository
public class UserReadDaoImpl implements UserReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMap;
    public Integer queryForId(String username, String pwd) throws Exception {
        Map map = new HashMap();
        map.put("username",username);
        map.put("pwd",pwd);
        return (Integer) sqlMap.queryForObject("user_sql_map.query_for_id",map);
    }
}
