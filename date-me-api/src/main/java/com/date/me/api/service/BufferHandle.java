package com.date.me.api.service;

import com.date.me.model.po.Massage;

/**
 * Created by shj on 17-3-10.
 */
public interface BufferHandle {
    void addUpdateBuffer(Integer msgId);
    void addMassageBuffer(Integer id,Massage massage);
    Massage getBufferMassage(Integer id);
    void updateBufferMsg(Integer id);
}
