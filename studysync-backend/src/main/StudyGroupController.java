package com.studysync.controller;

import com.studysync.entity.StudyGroup;
import com.studysync.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studygroups")
public class StudyGroupController {

    private final StudyGroupService service;

    @Autowired
    public StudyGroupController(StudyGroupService service) {
        this.service = service;
    }

    @PostMapping
    public StudyGroup createGroup(@RequestBody StudyGroup group) {
        return service.createGroup(group);
    }

    @GetMapping
    public List<StudyGroup> getAllGroups() {
        return service.getAllGroups();
    }
}
