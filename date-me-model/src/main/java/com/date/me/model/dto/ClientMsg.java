package com.date.me.model.dto;

import java.util.List;

/**
 * Created by shj on 17-3-8.
 */
public class ClientMsg {
    private Integer pid;
    private List<Integer> frlist;
    private MsgType msgtype;
    private Long time;
    private String content;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientMsg clientMsg = (ClientMsg) o;

        if (pid != null ? !pid.equals(clientMsg.pid) : clientMsg.pid != null) return false;
        if (frlist != null ? !frlist.equals(clientMsg.frlist) : clientMsg.frlist != null) return false;
        if (msgtype != clientMsg.msgtype) return false;
        if (time != null ? !time.equals(clientMsg.time) : clientMsg.time != null) return false;
        return content != null ? content.equals(clientMsg.content) : clientMsg.content == null;

    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (frlist != null ? frlist.hashCode() : 0);
        result = 31 * result + (msgtype != null ? msgtype.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientMsg{" +
                "pid=" + pid +
                ", frlist=" + frlist +
                ", msgtype=" + msgtype +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Integer> getFrlist() {
        return frlist;
    }

    public void setFrlist(List<Integer> frlist) {
        this.frlist = frlist;
    }

    public MsgType getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(MsgType msgtype) {
        this.msgtype = msgtype;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
