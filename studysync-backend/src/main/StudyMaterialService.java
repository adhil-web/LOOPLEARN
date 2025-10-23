package com.studysync.service;

import com.studysync.entity.StudyMaterial;
import com.studysync.repository.StudyMaterialRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudyMaterialService {

    private final StudyMaterialRepository repository;

    public StudyMaterialService(StudyMaterialRepository repository) {
        this.repository = repository;
    }

    public List<StudyMaterial> getMaterialsByGroup(Long groupId) {
        return repository.findByGroupId(groupId);
    }

    public StudyMaterial addMaterial(StudyMaterial material) {
        return repository.save(material);
    }
}
