package com.example.administrator.mochenkd.mvp.entity;

/**
 * Created by Administrator on 2018/4/7.
 */

public class KuaiDi {

    private String content;
    private String time;

    public KuaiDi(String time, String content) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}