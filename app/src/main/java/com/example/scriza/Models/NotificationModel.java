package com.example.scriza.Models;

public class NotificationModel {
    String heading;
    String datetime;

    public NotificationModel(String heading, String datetime) {
        this.heading = heading;
        this.datetime = datetime;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
