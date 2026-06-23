package com.example.kanbanboardsystem.model;

public class Task {
    private int id;
    private String title;
    private String description;
    private TaskStatus status;

    // קונסטרקטור (בנאי) ריק - חובה עבור ספריות רבות וגמישות בקוד
    public Task() {
    }

    // קונסטרקטור מלא ליצירת משימה חדשה
    public Task(int id, String title, String description, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // הגדרת גטרים וסטרים (Geters & Setters) כדי לגשת לשדות הפרטיים
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    // פונקציית toString - מעולה להדפסות ודיבאגינג בטרמינל
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}