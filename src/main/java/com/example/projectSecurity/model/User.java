package com.example.projectSecurity.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    private String roles = "";

    private String residence;

    //private String permissions = "";

    public User(String username, String password, String roles, String residence) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        //this.permissions = permissions;
        this.residence = residence;
        this.active=1;
    }

    protected User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }


    //    public String getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(String permissions) {
//        this.permissions = permissions;
//    }
}
