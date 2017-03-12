package com.date.me.business.write.dao;

import com.date.me.model.po.Massage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 17-3-8.
 */
public interface MassageWriteDao {
    void updateIsBufferById(List<Integer> ids)throws Exception;
    void insertMassage(List<Massage> massages)throws Exception;
}
