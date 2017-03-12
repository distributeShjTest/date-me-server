package com.date.me.model.dto;

/**
 * Created by shj on 17-3-10.
 */
public enum PidServerType {
    FRLIST(0),MSGSENT(1),LOGINERROR(2),MAGSENTERROR(3),PROTOCOLEROOR(4),CONNECTTIONSUCCESS(5);
    private int pid;
    private PidServerType(int pid){
        this.pid = pid;
    }

    public int getPid(){
        return this.pid;
    }

    public boolean equals(PidServerType p){
        return p.getPid()==this.pid;
    }



}
