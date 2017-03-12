package com.date.me.model.dto;

/**
 * Created by shj on 17-3-10.
 */
public enum MsgType {
    SHAKE(0),MSG(1);
    private int value;
    private MsgType(int value){
        this.value = value;
    }
    public int getValue(){
       return this.value;
    }
    public boolean equals(MsgType m){
        return m.getValue()==this.value;
    }
    public static MsgType getMsgType(int value){
        switch (value){
            case 0:
                return SHAKE;
            case 1:
                return MSG;
            default:
                return null;
        }
    }

}
