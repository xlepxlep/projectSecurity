package com.example.projectSecurity.model;

public class dto {

    private String name;
    private String password;
    private String role;
    private String residence;

    public dto(String name, String password, String role, String residence) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.residence = residence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }
}
