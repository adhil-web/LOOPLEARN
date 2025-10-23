package com.studysync.service;

import com.studysync.entity.StudyGroup;
import com.studysync.repository.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public StudyGroupService(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    public StudyGroup createGroup(StudyGroup group) {
        return studyGroupRepository.save(group);
    }

    public List<StudyGroup> getAllGroups() {
        return studyGroupRepository.findAll();
    }
}
