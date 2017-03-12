package com.date.me.model.dto;

/**
 * Created by shj on 17-3-8.
 */
public class ServerMsg {

    private Integer pid;
    private Integer frid;
    private MsgType msgtype;
    private Long time;
    private String content;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerMsg serverMsg = (ServerMsg) o;

        if (pid != null ? !pid.equals(serverMsg.pid) : serverMsg.pid != null) return false;
        if (frid != null ? !frid.equals(serverMsg.frid) : serverMsg.frid != null) return false;
        if (msgtype != serverMsg.msgtype) return false;
        if (time != null ? !time.equals(serverMsg.time) : serverMsg.time != null) return false;
        return content != null ? content.equals(serverMsg.content) : serverMsg.content == null;

    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (frid != null ? frid.hashCode() : 0);
        result = 31 * result + (msgtype != null ? msgtype.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServerMsg{" +
                "pid=" + pid +
                ", frid=" + frid +
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

    public Integer getFrid() {
        return frid;
    }

    public void setFrid(Integer frid) {
        this.frid = frid;
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
