package com.techprimers.springbatchexample1.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private Integer id;
    private String name;
    private String mail_id;
    private String notification_sent;
    private String process;
    private String status;

    public User(Integer id, String name, String mail_id, String notification_sent, String process, String status) {
        this.id = id;
        this.name = name;
        this.mail_id = mail_id;
        this.notification_sent = notification_sent;
        this.process = process;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getNotification_sent() {
        return notification_sent;
    }

    public void setNotification_sent(String notification_sent) {
        this.notification_sent = notification_sent;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail_id='" + mail_id + '\'' +
                ", notification_sent='" + notification_sent + '\'' +
                ", process='" + process + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
