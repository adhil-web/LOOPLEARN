package com.studysync.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "challenge_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long challengeId;
    private int score;
}
