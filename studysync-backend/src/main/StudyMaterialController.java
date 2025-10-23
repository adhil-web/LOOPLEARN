package com.studysync.controller;

import com.studysync.entity.StudyMaterial;
import com.studysync.service.StudyMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studymaterials")
public class StudyMaterialController {

    private final StudyMaterialService studyMaterialService;

    @Autowired
    public StudyMaterialController(StudyMaterialService studyMaterialService) {
        this.studyMaterialService = studyMaterialService;
    }

    @GetMapping("/group/{groupId}")
    public List<StudyMaterial> getMaterialsByGroup(@PathVariable Long groupId) {
        return studyMaterialService.getMaterialsByGroup(groupId);
    }

    @PostMapping
    public StudyMaterial addMaterial(@RequestBody StudyMaterial material) {
        return studyMaterialService.addMaterial(material);
    }
}
