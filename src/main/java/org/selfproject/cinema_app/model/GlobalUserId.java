package org.selfproject.cinema_app.model;

public class GlobalUserId {
    private static GlobalUserId instance = null;
    private Long userId;

    private GlobalUserId() {
    }

    public static synchronized GlobalUserId getInstance() {
        if (instance == null) {
            instance = new GlobalUserId();
        }
        return instance;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}