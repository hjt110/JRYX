package com.tong.library.utils;

public class Event<T> {

    private T date;

    public Event(T date) {
        this.date = date;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
