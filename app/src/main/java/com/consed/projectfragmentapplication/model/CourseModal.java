package com.consed.projectfragmentapplication.model;
public class CourseModal {

    // variables for our course
    // name and description.
    private String courseName;

    private String courseTracks;

    // creating constructor for our variables.

    public CourseModal(String courseName, String courseTracks) {
        this.courseName = courseName;
        this.courseTracks = courseTracks;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTracks() {
        return courseTracks;
    }

    public void setCourseTracks(String courseTracks) {
        this.courseTracks = courseTracks;
    }
}
