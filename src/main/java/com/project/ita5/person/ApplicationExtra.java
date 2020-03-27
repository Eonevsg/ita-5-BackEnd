package com.project.ita5.person;

import java.time.LocalDateTime;

public class ApplicationExtra {
    private LocalDateTime dateTime;
    private String notes = "";
    private String applicationValuation = "";
    private String interviewValuation = "";
    private String status;

    public ApplicationExtra(LocalDateTime dateTime, String notes, String applicationValuation, String interviewValuation, String status) {
        this.dateTime = dateTime;
        this.notes = notes;
        this.applicationValuation = applicationValuation;
        this.interviewValuation = interviewValuation;
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

    public ApplicationExtra(LocalDateTime dateTime, String notes, String applicationValuation, String interviewValuation) {
        this.dateTime = dateTime;
        this.notes = notes;
        this.applicationValuation = applicationValuation;
        this.interviewValuation = interviewValuation;
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

    public String getStatus() {
        return status;
    }
}
