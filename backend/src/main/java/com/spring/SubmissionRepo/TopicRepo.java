package com.spring.SubmissionRepo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Topic;

public interface TopicRepo extends JpaRepository<Topic,Long> {

    Topic findByTopicId(int topicId);
    List<Topic> findAll();
}
