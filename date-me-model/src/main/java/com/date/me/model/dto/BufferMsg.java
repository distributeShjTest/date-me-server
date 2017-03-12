package com.date.me.model.dto;

import com.date.me.model.po.Massage;

import java.util.*;

/**
 * Created by shj on 17-3-11.
 */
public class BufferMsg {
    private final int MAX_SIZE = 1000;
    private int size;
    private Map<Integer, LinkedList<Massage>> bufferMsgMap;
    private Map<Integer,LinkedList<Massage>> bufferUpdatedMap;
    public BufferMsg() {
        this.size = 0;
        this.bufferMsgMap = new HashMap<Integer, LinkedList<Massage>>();
        this.bufferUpdatedMap = new HashMap<Integer, LinkedList<Massage>>();
    }

    public boolean addBufferMsg(Integer id, Massage massage) {
        if (this.size > this.MAX_SIZE)
            return false;
            if (this.size > this.MAX_SIZE)
                return false;
            if (this.bufferMsgMap.get(id) == null) {
                LinkedList<Massage> list = new LinkedList<Massage>();
                list.add(massage);
                this.bufferMsgMap.put(id, list);
                this.size++;
            }else {
                this.bufferMsgMap.get(id).add(massage);
                this.size++;
            }
            return true;

    }

    public List<Massage> getMassages(Integer id) {
        return this.bufferMsgMap.get(id);
    }

    public Massage getFirstMassage(Integer id) {
        if (this.bufferMsgMap.get(id) == null)
            return null;
        return this.bufferMsgMap.get(id).removeFirst();
    }

    private void addUpdateMap(Integer id,Massage m){
        synchronized (this.bufferUpdatedMap){
            if(this.bufferUpdatedMap.get(id)==null){
                LinkedList<Massage> list = new LinkedList<Massage>();
                list.add(m);
                this.bufferUpdatedMap.put(id,list);
            }else {
                this.bufferUpdatedMap.get(id).add(m);
            }
        }
    }



    public boolean removeMassage(Integer id, Integer index) {
        if (this.bufferMsgMap.get(id) == null)
            return false;
        synchronized (this) {
            if (this.bufferMsgMap.get(id) == null)
                return false;
            if (this.bufferMsgMap.get(id).size() < index)
                return false;
            this.bufferMsgMap.get(id).remove(index);
            return true;
        }
    }

    public boolean removeOneMassage(Integer id) {
        if (this.bufferMsgMap.get(id) == null)
            return false;
        synchronized (this) {
            if (this.bufferMsgMap.get(id) == null)
                return false;
            this.bufferMsgMap.get(id).removeFirst();
            return true;
        }
    }


    public int getSize() {
        return size;
    }

    public boolean updateState(Integer id,Integer index){
        if (this.bufferMsgMap.get(id) == null)
            return false;
        synchronized (this) {
            if (this.bufferMsgMap.get(id) == null)
                return false;
            if(index>this.bufferMsgMap.get(id).size())
                return false;
            this.bufferMsgMap.get(id).get(index).setIsBuffer(1);
            return true;
        }
    }
    public boolean updateState(Integer id){
        if (this.bufferMsgMap.get(id) == null)
            return false;
        synchronized (this.bufferMsgMap) {
            if (this.bufferMsgMap.get(id) == null)
                return false;
            Massage massage =  this.bufferMsgMap.get(id).getFirst();
            massage.setIsBuffer(1);
            this.bufferMsgMap.get(id).removeFirst();
            this.addUpdateMap(id,massage);
            return true;
        }
    }


    public Map<Integer, LinkedList<Massage>> getBufferMsgMap() {
        return bufferMsgMap;
    }

    public List<Massage> maptoList(){
        List<Massage> massages = new ArrayList<Massage>();
        for(Integer i:this.bufferMsgMap.keySet()){
            for(Massage m:this.bufferMsgMap.get(i)){
                massages.add(m);
            }
        }
        for(Integer i:this.bufferUpdatedMap.keySet()){
            for(Massage m:this.bufferUpdatedMap.get(i)){
                massages.add(m);
            }
        }
        return massages;
    }


}
