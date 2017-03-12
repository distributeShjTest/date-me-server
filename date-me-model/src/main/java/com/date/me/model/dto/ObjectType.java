package com.date.me.model.dto;

/**
 * Created by shj on 17-3-10.
 */
public enum ObjectType {
    LOGINPROTOCOL(0),FRIEND(1),FRIENDLISTREQUEST(2),SERVERMSG(3),UPDATE(4),CLientMsg(5);
    private int id;
    private ObjectType(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public boolean equals(ObjectType o){
        if(this.id == o.getId()){
            return true;
        }
        return false;
    }


}
