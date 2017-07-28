package com.sinzoro.common.common;

public enum Message {
    
    DATABASE_ERROR(0, "A database error has occured."),
    WRONG_PASSWORD(0, "Incorrect Password."),
    DUPICATE_USER(0, "This user already exists."),
    LOGOUT_SUCCESS(0, "You've been logged out successfully.");
    
    private int code;
    private String description;
    
    private Message(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return code + " : " + description;
    }
    
}
