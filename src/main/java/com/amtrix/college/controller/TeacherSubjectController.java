package com.amtrix.college.controller;

import com.amtrix.college.entity.SubjectEntity;
import com.amtrix.college.entity.TeacherEntity;
import com.amtrix.college.entity.TeacherSubjectEntity;
import com.amtrix.college.service.SubjectService;
import com.amtrix.college.service.TeacherService;
import com.amtrix.college.service.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherSubjectController {
    @Autowired
    TeacherSubjectService teacherSubjectService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    // mapping to save subject
    @PostMapping("/teacherSubject")
    public long TeacherSubjectEntity(@RequestBody TeacherSubjectEntity teacherSubjectEntity) {
        //todo: check whether there is teacher in database or not
//        TeacherEntity teacherEntity = teacherService.findByName(teacherSubjectEntity.getTeacherEntity().getName());
//        if(teacherEntity == null) {
//            return -1L;
//        }

        //todo: check whether there is subject in database or not
//        SubjectEntity subjectEntity = subjectService.findByName(teacherSubjectEntity.getSubjectEntity().getName());
//        if (subjectEntity == null) {
//            return -1L;
//        }

        SubjectEntity subjectEntity = subjectService.getSubjectEntityById(teacherSubjectEntity.getSubjectEntity().getId());

        teacherSubjectEntity.setSubjectEntity(subjectEntity);

        TeacherEntity teacherEntity = teacherService.getTeacherEntityById(teacherSubjectEntity.getTeacherEntity().getId());

        teacherSubjectEntity.setTeacherEntity(teacherEntity);

        teacherSubjectService.saveOrUpdate(teacherSubjectEntity);
        return 1L;
    }

    @GetMapping("/teacherSubject/teacherName/{name}")
    public List<SubjectEntity> getSubjectListByTeacherName(@PathVariable("name") String name) {
        return teacherSubjectService.getSubjectListByTeacherName(name);
    }

    @GetMapping("/teacherSubject/subjectName/{name}")
    public List<TeacherEntity> getTeacherListBySubjectName(@PathVariable("name") String name) {
        return teacherSubjectService.getTeacherListBySubjectName(name);
    }
}
