package com.example.administrator.mochenkd.mvp.entity;

/**
 * Created by Administrator on 2018/4/8.
 */

public class copChoose {
    private int icon;//快递公司图标
    private String copName;//快递公司名字
    private String copPhone;//快递公司电话
    private String[]com;

    public copChoose() {
    }

    public copChoose(String[]com, int icon, String copName, String copPhone) {
        this.com=com;
        this.icon = icon;
        this.copName = copName;
        this.copPhone = copPhone;

    }

    public String[]getCom() {
        return com;
    }

    public void setCom(String[]com) {
        this.com = com;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCopName() {
        return copName;
    }

    public void setCopName(String copName) {
        this.copName = copName;
    }

    public String getCopPhone() {
        return copPhone;
    }

    public void setCopPhone(String copPhone) {
        this.copPhone = copPhone;
    }
}
