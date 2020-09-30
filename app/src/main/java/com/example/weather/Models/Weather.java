package com.example.weather.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("timezone")
    @Expose
    private int timezone;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("main")
    @Expose
    private Main main;

    public Weather(int id, int timezone, String name) {
        this.id = id;
        this.timezone = timezone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }
}
