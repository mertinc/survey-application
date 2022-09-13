package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@PostMapping("/createSubmission")
    public ResponseEntity<Submission> createUser(@RequestBody Submission submission) {
        try {
            Submission _submission = submissionRepo.save(new Submission(submission.getComment(), submission.getId(), submission.getScore()));
            return new ResponseEntity<>(_submission, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}