package com.date.me.model.dto;

/**
 * Created by shj on 17-3-10.
 */
public class JSONAnalyze {
    private int id;
    private ObjectType ObjectType;
    private Object object;



    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONAnalyze that = (JSONAnalyze) o;

        if (id != that.id) return false;
        if (ObjectType != that.ObjectType) return false;
        return object != null ? object.equals(that.object) : that.object == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ObjectType != null ? ObjectType.hashCode() : 0);
        result = 31 * result + (object != null ? object.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JSONAnalyze{" +
                "id=" + id +
                ", ObjectType=" + ObjectType +
                ", object=" + object +
                '}';
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.date.me.model.dto.ObjectType getObjectType() {
        return ObjectType;
    }

    public void setObjectType(com.date.me.model.dto.ObjectType objectType) {
        ObjectType = objectType;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
