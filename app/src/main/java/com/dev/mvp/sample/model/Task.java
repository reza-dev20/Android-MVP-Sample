package com.dev.mvp.sample.model;

public class Task {
    private long id;
    private String title;
    private boolean isCompleted;
    private int importance=IMPORTANCE_NORMAL;

    public static final int IMPORTANCE_HIGH = 2;
    public static final int IMPORTANCE_NORMAL = 1;
    public static final int IMPORTANCE_LOW = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
