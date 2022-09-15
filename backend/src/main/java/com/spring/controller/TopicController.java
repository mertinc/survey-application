package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Submission;
import com.spring.model.Topic;
import com.spring.SubmissionRepo.*;
//import com.spring.TopicRepo.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    SubmissionRepo submissionRepo;

    @Autowired
    TopicRepo topicRepo;

    @GetMapping("/getAllTopics")
    public ResponseEntity<List<Topic>> getAllTopics(@RequestParam(required = false) Integer topicId){
        try {
            List<Topic> topics = new ArrayList<Topic>();
            
            topicRepo.findAll().forEach(topics::add);

            for (Topic topic : topics) {
                updateTopicNpm(topic);
            }

            if (topics.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(topics, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
    @GetMapping("/updateTopicNpm")
    public void updateTopicNpm(@PathVariable("topicId") Topic topic){
       
            List<Submission> submissions = new ArrayList<Submission>();
            submissionRepo.findAllByTopicId(topic).forEach(submissions::add);
            
            int submissionLength = submissions.size();
            int promoters = 0;
            int detractors = 0;

            for (Submission submission : submissions) {
                if(submission.getScore()>=9){
                    promoters++;
                }
                else if(submission.getScore()<=6){
                    detractors++;
                }
            }
            int npmResult=(promoters-detractors)*100/submissionLength;

            Topic _topic = new Topic();
            
            _topic= topicRepo.findByTopicId(topic.getTopicId());
            
            _topic.setNpmscore(npmResult);
            topicRepo.save(_topic);
                
    
    }
}
