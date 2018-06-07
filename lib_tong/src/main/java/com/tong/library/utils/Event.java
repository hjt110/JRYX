package com.tong.library.utils;

public class Event<T> {

    private int code;
    private T date;

    public Event(int code) {
        this.code = code;
    }

    public Event(T date) {
        this.date = date;
    }

    public Event(int code, T date) {
        this.code = code;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
