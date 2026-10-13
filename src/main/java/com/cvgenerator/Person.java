package com.cvgenerator;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String fullName;
    private String email;
    private String phone;
    private String imagePath;
    private List<WorkExperience> experiences;

    // Constructor
    public Person(String fullName, String email, String phone, String imagePath) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.imagePath = imagePath;
        this.experiences = new ArrayList<>();
    }

    public void addWorkExperience(WorkExperience experience) {
        this.experiences.add(experience);
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<WorkExperience> getExperiences() {
        return experiences;
    }
}