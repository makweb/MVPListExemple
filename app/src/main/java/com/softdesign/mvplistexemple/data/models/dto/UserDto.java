package com.softdesign.mvplistexemple.data.models.dto;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Makweb on 04.11.2016.
 */
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String shortMessage;
    private int color;

    public UserDto(int id, String firstName, String lastName, String shortMessage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.shortMessage = shortMessage;
        Random rnd = new Random();
        this.color = Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    public String getShortMessage() {
        return shortMessage;
    }

    public String getAbbrivation() {
        return (firstName.substring(0,1) + lastName.substring(0,1)).toUpperCase();
    }

    public int getColor() {
        return color;
    }
}

