package com.dto;

import com.demo.entity.Sites;

public class UserDto {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String login;

    private String password;
    private String role;
    private String region;
    private int site;

    // Getters and Setters

    public String getFullName() {
        return fullName;
    }

    public int getsite() {
        return this.site;
    }

    public void setSite(int sitee) {
        this.site = sitee;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
