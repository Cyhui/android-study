package com.example.myapplication;

/**
 * Created by 54459 on 2017/5/9 0009.
 */

public class Msg {

    public static final int TYPE_RECEIVED = 0;//收到的消息

    public static final int TYPE_SENT = 1;//发送的消息

    private String content;

    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
