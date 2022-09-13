package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="submissions")
public class Submission{

    @Id
    private long id;

    @Column(name="score")
    private int score;

    @Column(name="comment")
    private String comment;

    public Submission(){

    }

    public Submission(String comment, long id, int score) {
        this.id = id;
        this.score = score;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}