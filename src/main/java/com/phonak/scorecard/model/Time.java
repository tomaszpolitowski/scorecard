package com.phonak.scorecard.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Time {
   @NotNull
    Integer indleTime;
    @NotNull(message = "Date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    @NotNull
    Integer totalTimeWorked ;

    public Time() {
    }

    public Time(@NotNull Integer indleTime, @NotNull(message = "Date cannot be empty") LocalDate date, @NotNull Integer totalTimeWorked) {
        this.indleTime = indleTime;
        this.date = date;
        this.totalTimeWorked = totalTimeWorked;
    }

    public Integer getIndleTime() {
        return indleTime;
    }

    public void setIndleTime(Integer indleTime) {
        this.indleTime = indleTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTotalTimeWorked() {
        return totalTimeWorked;
    }

    public void setTotalTimeWorked(Integer totalTimeWorked) {
        this.totalTimeWorked = totalTimeWorked;
    }
}
