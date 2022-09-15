package com.spring.SubmissionRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Topic;

public interface TopicRepo extends JpaRepository<Topic,Long> {

    List<Topic> findByTopicId(int topicId);
    
}
