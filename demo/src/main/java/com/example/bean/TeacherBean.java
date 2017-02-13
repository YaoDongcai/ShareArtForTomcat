package com.example.bean;

/**
 * Created by yaodongcai on 2017/1/15.
 */
// 教员的属性

public class TeacherBean {
    private String objectId; // 主键id;
    private String worked; // 工作室名称
    private String name; // 姓名
    private String teacher_ideas; // 教员口号
    private String nickname; // 昵称
    private String teacher_age; // 教员教龄
    private String star; // 火热度
    private String img_url; // 图片名称
    private String dipnoma; // 学历
    private String teacher_area; // 教员的地区
    private String teacher_methods; // 教员的方法理念
    private String music_instruments; // 教员擅长的乐器;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getWorked() {
        return worked;
    }

    public void setWorked(String worked) {
        this.worked = worked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_ideas() {
        return teacher_ideas;
    }

    public void setTeacher_ideas(String teacher_ideas) {
        this.teacher_ideas = teacher_ideas;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTeacher_age() {
        return teacher_age;
    }

    public void setTeacher_age(String teacher_age) {
        this.teacher_age = teacher_age;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDipnoma() {
        return dipnoma;
    }

    public void setDipnoma(String dipnoma) {
        this.dipnoma = dipnoma;
    }

    public String getTeacher_area() {
        return teacher_area;
    }

    public void setTeacher_area(String teacher_area) {
        this.teacher_area = teacher_area;
    }

    public String getTeacher_methods() {
        return teacher_methods;
    }

    public void setTeacher_methods(String teacher_methods) {
        this.teacher_methods = teacher_methods;
    }

    public String getMusic_instruments() {
        return music_instruments;
    }

    public void setMusic_instruments(String music_instruments) {
        this.music_instruments = music_instruments;
    }
}
