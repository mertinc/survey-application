package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="submissions")
public class Submission implements Serializable{

    @Id
    private long id;

    @Column(name="score")
    private int score;

    @Column(name="comment")
    private String comment;

    @OneToOne
    @JoinColumn(name="topicId")
    private Topic topicId;

    public Submission(){

    }

    public Submission(String comment,long id, int score, Topic topicId) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.topicId = topicId;
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

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    
}