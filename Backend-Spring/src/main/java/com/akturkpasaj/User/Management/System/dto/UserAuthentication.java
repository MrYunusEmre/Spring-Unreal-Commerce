package com.akturkpasaj.User.Management.System.dto;

public class UserAuthentication {
    private String username;
    private String password;

    public UserAuthentication() {
    }

    public UserAuthentication(String email, String password) {
        this.username = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAuthentication{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
