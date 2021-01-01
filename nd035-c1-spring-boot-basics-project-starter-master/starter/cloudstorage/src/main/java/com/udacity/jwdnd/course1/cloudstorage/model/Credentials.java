package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credentials {
    private String username;
    private String url;
    private String key;
    private String password;
    private int userid;
    private int credentialid;

    public Credentials(String username, String url, String key, String password, int userid, int credentialid) {
        this.username = username;
        this.url = url;
        this.key = key;
        this.password = password;
        this.userid = userid;
        this.credentialid = credentialid;
    }

    public Credentials() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(int credentialid) {
        this.credentialid = credentialid;
    }
}

