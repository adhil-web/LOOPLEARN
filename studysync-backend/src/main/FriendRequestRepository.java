package com.studysync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studysync.entity.FriendRequest;
import java.util.List;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    List<FriendRequest> findByReceiverIdAndAcceptedFalse(Long receiverId);
}
