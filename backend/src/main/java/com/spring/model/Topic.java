package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="topic")
public class Topic implements Serializable{

    @Id
    private int topicId;

    @Column(name="topic")
    private String topic;

    @Column(name="npmscore")
    private Integer npmscore;

    public Topic() {
    }

    public Topic(int topicId, String topic, Integer npmscore) {
        this.topicId = topicId;
        this.topic = topic;
        this.npmscore = npmscore;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getNpmscore() {
        return npmscore;
    }

    public void setNpmscore(Integer npmscore) {
        this.npmscore = npmscore;
    }

    
    

    
}