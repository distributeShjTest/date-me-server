package com.date.me.business.read.dao;

import com.date.me.model.po.Massage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shj on 17-3-8.
 */

public interface MassageReadDao {
    List<Massage> queryBufferMsg(int id)throws Exception;


}
