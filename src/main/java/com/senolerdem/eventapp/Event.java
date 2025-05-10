package com.senolerdem.eventapp;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private static int counter = 1;
    private final int id;
    private String name;
    private String location;
    private String date;
    private String time;
    private String organizer;
    private String description;
    private List<String> categories;
    private List<String> tags;
    private int registrationCount;

    public Event(String name, String location, String date, String time, String organizer,
                 List<String> categories, List<String> tags ,String description) {
        this.id = counter++;
        this.name = name;
        this.location = location;
        this.date = date;
        this.time = time;
        this.organizer = organizer;
        this.categories = new ArrayList<>(categories);
        this.tags = new ArrayList<>(tags);
        this.registrationCount = 0;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getTags() {
        return tags;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getRegistrationCount() {
        return registrationCount;
    }
    public String getLocation() {
        return location;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }


    public void incrementRegistration() {
        registrationCount++;
    }

    public void decrementRegistration() {
        if (registrationCount > 0) {
            registrationCount--;
        }
    }

    @Override
    public String toString() {
        return "Event ID: " + id +
                "\nName: " + name +
                "\nLocation: " + location +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nOrganizer: " + organizer +
                "\nCategories: " + categories +
                "\nTags: " + tags +
                "\nRegistration Count: " + registrationCount;
    }
}
