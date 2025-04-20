package com.jerome.habits.model;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "habits")// This tells Spring Data MongoDB the collection name
public class Habit {

    @Id
    private String habit_id;
    private String user_id;
    private String title;
    private String frequency;
    private boolean status;
    private LocalDateTime created_datetime;
    private LocalDateTime completed_datetime;

    Habit(String habit_id, String user_id, String title, String frequency, boolean status,
    LocalDateTime created_datetime, LocalDateTime completed_datetime) {
        this.habit_id = habit_id;
        this.user_id = user_id;
        this.title = title;
        this.frequency = frequency;
        this.status = status;
        this.created_datetime = created_datetime;
        this.completed_datetime = completed_datetime;
    }

    public String getHabit_id() {
        return habit_id;
    }

    public void setHabit_id(String habit_id) {
        this.habit_id = habit_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreated_datetime() {
        return created_datetime;
    }

    public void setCreated_datetime(LocalDateTime created_datetime) {
        this.created_datetime = created_datetime;
    }

    public LocalDateTime getCompleted_datetime() {
        return completed_datetime;
    }

    public void setCompleted_datetime(LocalDateTime completed_datetime) {
        this.completed_datetime = completed_datetime;
    }
}