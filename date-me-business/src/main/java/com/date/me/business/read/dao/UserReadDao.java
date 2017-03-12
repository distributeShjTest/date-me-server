package com.date.me.business.read.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by shj on 17-3-8.
 */

public interface UserReadDao {
    Integer queryForId(String username,String pwd)throws Exception;

}
