package com.date.me.model.dto;

/**
 * Created by shj on 17-3-8.
 */
public class LoginProtocol {
    private Integer pid;
    private String username;
    private String pwd;



    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginProtocol that = (LoginProtocol) o;

        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return pwd != null ? pwd.equals(that.pwd) : that.pwd == null;

    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginProtocol{" +
                "pid=" + pid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

}
