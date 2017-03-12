package com.date.me.model.dto;

/**
 * Created by shj on 17-3-10.
 */
public enum ProtocolType {
    PID("pid"),USERNAME("username"),PWD("pwd"),FRLIST("frlist"),MSGTYPE("msgtype"),
    TIME("time"),CONTENT("content"),FRID("frid"),ID("id"),NAME("name");
    private String value;
    private ProtocolType(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    public boolean equals(ProtocolType p){
        return p.getValue().equals(this.value);
    }


}
