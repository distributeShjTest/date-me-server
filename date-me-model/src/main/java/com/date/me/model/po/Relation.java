package com.date.me.model.po;

/**
 * Created by shj on 17-3-8.
 */
public class Relation {
    private Integer id;
    private Integer frLowId;
    private String frLowUsername;
    private Integer frHighId;
    private String frHighUsername;
    private Integer isDelete;


    @Override
    public String toString() {
        return "Relation{" +
                "id=" + id +
                ", frLowId=" + frLowId +
                ", frLowUsername='" + frLowUsername + '\'' +
                ", frHighId=" + frHighId +
                ", frHighUsername='" + frHighUsername + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrLowId() {
        return frLowId;
    }

    public void setFrLowId(Integer frLowId) {
        this.frLowId = frLowId;
    }

    public String getFrLowUsername() {
        return frLowUsername;
    }

    public void setFrLowUsername(String frLowUsername) {
        this.frLowUsername = frLowUsername;
    }

    public Integer getFrHighId() {
        return frHighId;
    }

    public void setFrHighId(Integer frHighId) {
        this.frHighId = frHighId;
    }

    public String getFrHighUsername() {
        return frHighUsername;
    }

    public void setFrHighUsername(String frHighUsername) {
        this.frHighUsername = frHighUsername;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relation relation = (Relation) o;

        if (id != null ? !id.equals(relation.id) : relation.id != null) return false;
        if (frLowId != null ? !frLowId.equals(relation.frLowId) : relation.frLowId != null) return false;
        if (frLowUsername != null ? !frLowUsername.equals(relation.frLowUsername) : relation.frLowUsername != null)
            return false;
        if (frHighId != null ? !frHighId.equals(relation.frHighId) : relation.frHighId != null) return false;
        if (frHighUsername != null ? !frHighUsername.equals(relation.frHighUsername) : relation.frHighUsername != null)
            return false;
        return isDelete != null ? isDelete.equals(relation.isDelete) : relation.isDelete == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (frLowId != null ? frLowId.hashCode() : 0);
        result = 31 * result + (frLowUsername != null ? frLowUsername.hashCode() : 0);
        result = 31 * result + (frHighId != null ? frHighId.hashCode() : 0);
        result = 31 * result + (frHighUsername != null ? frHighUsername.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }
}
