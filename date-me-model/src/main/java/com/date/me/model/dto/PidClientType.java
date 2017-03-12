package com.date.me.model.dto;

/**
 * Created by shj on 17-3-10.
 */
public enum PidClientType {
    LOGIN(0),UPDATE(1),MAGSENT(2);

    PidClientType(int pid){

        this.pid = pid;
    }
    private int pid;
    public int getPID(){
       return this.pid;
    }
    private boolean equals(PidClientType p){
        return p.getPID()==this.pid;
    }

    public static PidClientType getPidClintType(int pid){
        switch (pid){
            case 0:
                return LOGIN;
            case 1:
                return UPDATE;
            case 2:
                return MAGSENT;
            default:
                return null;
        }
    }




}
