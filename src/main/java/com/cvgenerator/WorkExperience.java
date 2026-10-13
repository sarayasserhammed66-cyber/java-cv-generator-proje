package com.cvgenerator;

public class WorkExperience {
    private String companyName;
    private String jobTitle;
    private String duration;
    private String description;

    // Constructor
    public WorkExperience(String companyName, String jobTitle, String duration, String description) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.duration = duration;
        this.description = description;
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
