package com.shoppingmall.cdz.bean;

import java.io.Serializable;

/**
 * Created by oldwang on 2019/1/22 0022.
 */

public class NoticeMessageBean implements Serializable {

    private int id;
    private String type;
    private String title;
    private String content;

    private String newsTime;

    public String getNewsTime() {
        return newsTime;
    }

    public NoticeMessageBean(){

    }
    public NoticeMessageBean(String type,String title,int id){
        this.type = type;
        this.title = title;
        this.id = id;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
