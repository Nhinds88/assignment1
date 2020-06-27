package com.cst438.assignment1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min=3, max=25)
    private String title;

    @NotNull
    @Size(min=3, max=25)
    private String rating;

    @NotNull
    @Size(min=3, max=25)
    private String reviewer;

    @NotNull
    private String dateTime;

    public Rating() {
        title = null;
        rating = null;
        reviewer = null;
        dateTime = null;
    }

    public Rating(long id, String title, String rating, String reviewer) {
        super();
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.reviewer = reviewer;
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getDateTime() {
        dateTime = new java.util.Date().toString();
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
