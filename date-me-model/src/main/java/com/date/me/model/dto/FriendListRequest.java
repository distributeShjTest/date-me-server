package com.date.me.model.dto;

import java.util.List;

/**
 * Created by shj on 17-3-8.
 */
public class FriendListRequest {
    private Integer pid;
    private List<Friend> friends;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendListRequest that = (FriendListRequest) o;

        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        return friends != null ? friends.equals(that.friends) : that.friends == null;

    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        return result;
    }

    @Override
    public String
    toString() {
        return "FriendListRequest{" +
                "pid=" + pid +
                ", friends=" + friends +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
