package com.studysync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.studysync.service.FriendService;
import com.studysync.entity.FriendRequest;
import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/{receiverId}")
    public List<FriendRequest> getFriendRequests(@PathVariable Long receiverId) {
        return friendService.getFriendRequests(receiverId);
    }

    @PostMapping
    public FriendRequest sendRequest(@RequestBody FriendRequest request) {
        return friendService.sendRequest(request);
    }
}
