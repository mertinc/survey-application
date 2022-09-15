package com.spring.SubmissionRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.model.Submission;

import java.util.List;

public interface SubmissionRepo extends JpaRepository<Submission,Long> {
    
    List<Submission> findById(long id);
    List<Submission> findAllByTopicId(int topicId);
}
