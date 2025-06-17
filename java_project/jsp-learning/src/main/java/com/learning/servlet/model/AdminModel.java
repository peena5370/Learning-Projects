package com.learning.servlet.model;

/**
 * Admin Model
 *
 * @author Peena
 * @since 3/1/2022
 */
public class AdminModel {

    private String username;
    private String password;
    private String key;
    private String role;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
