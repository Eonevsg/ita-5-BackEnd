package com.project.ita5.person;

import java.time.LocalDateTime;

public class ApplicationExtra {
    private LocalDateTime dateTime;
    private String notes;
    private String applicationValuation;
    private String interviewValuation;

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
}
