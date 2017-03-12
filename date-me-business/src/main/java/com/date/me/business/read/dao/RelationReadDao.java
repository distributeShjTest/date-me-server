package com.date.me.business.read.dao;

import com.date.me.model.po.Relation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shj on 17-3-8.
 */

public interface RelationReadDao {
    public List<Relation> queryForRelationById(Integer id)throws Exception;


}
