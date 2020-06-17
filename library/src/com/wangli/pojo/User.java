package com.wangli.pojo;

public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String userid;
    private String regdate;

    public User(Integer id, String username, String password, String email, String userid, String regdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userid = userid;
        this.regdate = regdate;
    }

    public User() {
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getUserid() {
        return userid;
    }

    public String getRegdate() {
        return regdate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userid='" + userid + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
