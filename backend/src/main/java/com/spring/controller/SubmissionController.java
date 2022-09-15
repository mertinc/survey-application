package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Submission;
import com.spring.SubmissionRepo.*;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

@Autowired
SubmissionRepo submissionRepo;

@GetMapping("/getSubmissionsbyTopicId/{topicId}")
    public ResponseEntity<List<Submission>> getSubmissionsByTopicId(@PathVariable("topicId") int topicId){
        try {
            List<Submission> submissions = new ArrayList<Submission>();
            submissionRepo.findAllByTopicId(topicId).forEach(submissions::add);
            if (submissions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(submissions, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

@CrossOrigin
@PostMapping("/createSubmission")
    public ResponseEntity<Submission> createUser(@RequestBody Submission submission) {
        try {
            Submission _submission = submissionRepo.save(new Submission(submission.getComment(), submission.getId(), submission.getScore(),submission.getTopicId()));
            return new ResponseEntity<>(_submission, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}