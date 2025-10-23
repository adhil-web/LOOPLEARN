package com.studysync.service;

import com.studysync.entity.FriendRequest;
import com.studysync.repository.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    private final FriendRequestRepository repository;

    @Autowired
    public FriendService(FriendRequestRepository repository) {
        this.repository = repository;
    }

    public List<FriendRequest> getFriendRequests(Long receiverId) {
        return repository.findByReceiverIdAndAcceptedFalse(receiverId);
    }

    public FriendRequest sendRequest(FriendRequest request) {
        return repository.save(request);
    }

    public void acceptRequest(FriendRequest request) {
        request.setAccepted(true);
        repository.save(request);
    }
}

