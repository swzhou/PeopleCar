package com.peoplecar.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/11/12
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Greeting {
    private String name;
    private String message;
    private String time;

    public Greeting(String name, String message) {
        this.name = name;
        this.message = message;
        this.time = getDateTime();
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
