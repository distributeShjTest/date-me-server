package com.date.me.business.read.manage;

import com.date.me.model.dto.ServerMsg;
import com.date.me.model.po.Massage;

import java.util.List;

/**
 * Created by shj on 17-3-10.
 */
public interface MassageReadManage {
    public List<Massage> getBufferMsg(Integer id)throws Exception;
}
