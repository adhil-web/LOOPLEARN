package com.studysync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studysync.repository.ChallengeRepository;

@Service
public class ChallengeService {

    private final ChallengeRepository repository;

    @Autowired
    public ChallengeService(ChallengeRepository repository) {
        this.repository = repository;
    }

    // Add your service methods here
}
