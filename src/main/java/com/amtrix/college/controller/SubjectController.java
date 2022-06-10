package com.amtrix.college.controller;

import com.amtrix.college.entity.SubjectEntity;
import com.amtrix.college.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    // getting all subject details
    @GetMapping("/subject")
    private List<SubjectEntity> getAllSubjectEntity() {
        return subjectService.getAllSubjectEntity();
    }

    // mapping to get specific subject details
    @GetMapping("/subject/{id}")
    private SubjectEntity getSubjectEntity(@PathVariable("id") long id) {
        return subjectService.getSubjectEntityById(id);
    }

    // mapping to delete specific subject details
    @DeleteMapping("/subject/{id}")
    private void deleteSubjectEntity(@PathVariable("id") long id) {
        subjectService.delete(id);
    }

    // mapping to save subject details
    @PostMapping("/subject")
    private long saveSubjectEntity(@RequestBody SubjectEntity subjectEntity) {
        subjectService.saveOrUpdate(subjectEntity);
        return subjectEntity.getId();
    }

    // mapping to update subject details
    @PutMapping("/subject")
    private SubjectEntity update(@RequestBody SubjectEntity subjectEntity) {
        subjectService.saveOrUpdate(subjectEntity);
        return subjectEntity;
    }
}
