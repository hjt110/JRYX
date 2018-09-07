package com.tong.library.utils;

public class MessageEvent<T> {

    private String msg;
    private T date;

    public MessageEvent(String msg) {
        this.msg = msg;
    }

    public MessageEvent(String msg, T date) {
        this.msg = msg;
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
