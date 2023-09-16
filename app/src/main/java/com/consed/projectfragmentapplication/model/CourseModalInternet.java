package com.consed.projectfragmentapplication.model;
public class CourseModalInternet {
    private String id;
    private String id_BLAM;
    private String title;
    private String body;

    public CourseModalInternet(String id, String id_BLAM, String title, String body) {
        this.id = id;
        this.id_BLAM = id_BLAM;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_BLAM() {
        return id_BLAM;
    }

    public void setId_BLAM(String id_BLAM) {
        this.id_BLAM = id_BLAM;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
