package com.project.ita5.person;

import java.time.LocalDateTime;

public class ApplicationExtra {
    private LocalDateTime dateTime;
    private String notes = "";
    private String applicationValuation = "";
    private String interviewValuation = "";
    private String testValuation="";
    private String status;

    public ApplicationExtra(LocalDateTime dateTime, String notes, String applicationValuation, String interviewValuation, String testValuation, String status) {
        this.dateTime = dateTime;
        this.notes = notes;
        this.applicationValuation = applicationValuation;
        this.interviewValuation = interviewValuation;
        this.testValuation = testValuation;
        this.status = status;
    }

    public ApplicationExtra() {
    }

    public ApplicationExtra(LocalDateTime dateTime, String status) {
        this.dateTime = dateTime;
        this.status = status;
    }

    public ApplicationExtra(String status) {
        this.status = status;
    }

    public ApplicationExtra(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ApplicationExtra(LocalDateTime dateTime, String notes, String applicationValuation, String interviewValuation, String testValuation) {
        this.dateTime = dateTime;
        this.notes = notes;
        this.applicationValuation = applicationValuation;
        this.interviewValuation = interviewValuation;
        this.testValuation = testValuation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getNotes() {
        return notes;
    }

    public String getApplicationValuation() {
        return applicationValuation;
    }

    public String getInterviewValuation() {
        return interviewValuation;
    }
    public String getTestValuation() { return testValuation; }

    public String getStatus() {
        return status;
    }
}
