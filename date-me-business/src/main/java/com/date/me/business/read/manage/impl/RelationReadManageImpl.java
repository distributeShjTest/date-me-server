package com.date.me.business.read.manage.impl;

import com.date.me.business.read.dao.RelationReadDao;
import com.date.me.business.read.manage.RelationReadManage;
import com.date.me.model.dto.Friend;
import com.date.me.model.po.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
@Service
public class RelationReadManageImpl implements RelationReadManage {
    @Autowired
    private RelationReadDao relationReadDao;

    public List<Friend> getRelation(Integer id) throws Exception {
        List<Relation> relations =  this.relationReadDao.queryForRelationById(id);
        List<Friend> friends = new ArrayList<Friend>();
        for(Relation r:relations){
            if(r.getFrLowId().equals(id)){
                Friend f = new Friend();
                f.setId(r.getFrHighId());
                f.setName(r.getFrHighUsername());
                friends.add(f);
            }else {
                Friend f = new Friend();
                f.setId(r.getFrLowId());
                f.setName(r.getFrLowUsername());
                friends.add(f);
            }
        }
        return friends;
    }
}
