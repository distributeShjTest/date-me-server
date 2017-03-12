package com.date.me.api.protocol;

import com.date.me.model.dto.JSONAnalyze;
import com.date.me.model.dto.ObjectType;
import com.date.me.model.dto.PidClientType;

/**
 * Created by shj on 17-3-10.
 */
public interface Analyze {
    JSONAnalyze analyze(String JSONString,int pid,int id);
    boolean equals(ObjectType o);
    boolean equals(PidClientType p);
}
