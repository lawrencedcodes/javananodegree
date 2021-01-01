package com.udacity.jwdnd.course1.cloudstorage.model;

public class Notes {
    private int noteid;
    private String notetitle;
    private String notedescription;
    private int userid;

    public Notes(String notetitle, String notedescription, int userid) {
        this.notetitle = notetitle;
        this.notedescription = notedescription;
        this.userid = userid;
    }

    public Notes() {
    }

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotedescription() {
        return notedescription;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}



//    CREATE TABLE IF NOT EXISTS NOTES (
//        noteid INT PRIMARY KEY auto_increment,
//        notetitle VARCHAR(20),
//    notedescription VARCHAR (1000),
//    userid INT,
//    foreign key (userid) references USERS(userid)
//        );