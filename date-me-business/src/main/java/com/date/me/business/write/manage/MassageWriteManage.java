package com.date.me.business.write.manage;

import com.date.me.model.po.Massage;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public interface MassageWriteManage {
    void updateIsBufferById(List<Integer> ids)throws Exception;
    void insertMassage(List<Massage> massages)throws Exception;
}
