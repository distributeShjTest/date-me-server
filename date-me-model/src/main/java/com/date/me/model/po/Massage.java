package com.date.me.model.po;

/**
 * Created by shj on 17-3-8.
 */
public class Massage {
    private Integer id;
    private Integer sendId;
    private Long time;
    private Integer recieveId;
    private Integer msgType;
    private String content;
    private Integer isDelete;
    private Integer isBuffer;


    public Massage() {
    }

    public Massage(Integer id, Integer sendId, Long time, Integer recieveId, Integer msgType, String content, Integer isDelete, Integer isBuffer) {
        this.id = id;
        this.sendId = sendId;
        this.time = time;
        this.recieveId = recieveId;
        this.msgType = msgType;
        this.content = content;
        this.isDelete = isDelete;
        this.isBuffer = isBuffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Massage massage = (Massage) o;

        if (id != null ? !id.equals(massage.id) : massage.id != null) return false;
        if (sendId != null ? !sendId.equals(massage.sendId) : massage.sendId != null) return false;
        if (time != null ? !time.equals(massage.time) : massage.time != null) return false;
        if (recieveId != null ? !recieveId.equals(massage.recieveId) : massage.recieveId != null) return false;
        if (msgType != null ? !msgType.equals(massage.msgType) : massage.msgType != null) return false;
        if (content != null ? !content.equals(massage.content) : massage.content != null) return false;
        if (isDelete != null ? !isDelete.equals(massage.isDelete) : massage.isDelete != null) return false;
        return isBuffer != null ? isBuffer.equals(massage.isBuffer) : massage.isBuffer == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sendId != null ? sendId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (recieveId != null ? recieveId.hashCode() : 0);
        result = 31 * result + (msgType != null ? msgType.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (isBuffer != null ? isBuffer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "id=" + id +
                ", sendId=" + sendId +
                ", time=" + time +
                ", recieveId=" + recieveId +
                ", msgType=" + msgType +
                ", content='" + content + '\'' +
                ", isDelete=" + isDelete +
                ", isBuffer=" + isBuffer +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getRecieveId() {
        return recieveId;
    }

    public void setRecieveId(Integer recieveId) {
        this.recieveId = recieveId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsBuffer() {
        return isBuffer;
    }

    public void setIsBuffer(Integer isBuffer) {
        this.isBuffer = isBuffer;
    }
}
