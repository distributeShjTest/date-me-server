package com.date.me.business.read.manage;

import com.date.me.model.dto.Friend;
import com.date.me.model.po.Relation;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public interface RelationReadManage {
    public List<Friend> getRelation(Integer id)throws Exception;
}
