package com.amtrix.college.controller;

import com.amtrix.college.entity.StudentEntity;
import com.amtrix.college.entity.StudentSubjectEntity;
import com.amtrix.college.entity.SubjectEntity;
import com.amtrix.college.service.StudentService;
import com.amtrix.college.service.StudentSubjectService;
import com.amtrix.college.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentSubjectController {

    @Autowired
    StudentSubjectService studentSubjectService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    // mapping to save subject
    @PostMapping("/studentSubject")
    private long saveStudentSubjectEntity(@RequestBody StudentSubjectEntity studentSubjectEntity) {
//        //todo: check whether there is student in database or not
//        StudentEntity studentEntity = studentService.findByName(studentSubjectEntity.getStudentEntity().getName());
//        if(studentEntity == null) {
//            return -1L;
//        }
//
//        //todo: check whether there is subject in database or not
//        SubjectEntity subjectEntity = subjectService.findByName(studentSubjectEntity.getSubjectEntity().getName());
//        if (subjectEntity == null) {
//            return -1L;
//        }

        studentSubjectService.saveOrUpdate(studentSubjectEntity);

        return 1l;
    }

    // getting subject name through student name
    @GetMapping("/studentSubject/{name}")
    private Long getSubjectName(@PathVariable("name") String name) {
        //Long process
        //todo: find student by name -> studentEntity
        //todo: find student_subject by studentEntityId
        //todo: find subject using student_subject.subject_id
        //todo: print subject name

        return 1L;
    }

    @GetMapping("/studentSubject/id/{id}")
    public StudentSubjectEntity getById(@PathVariable("id") Long id) {
        return studentSubjectService.getById(id);
    }

//     getting subject list Details through student name
    @GetMapping("/studentSubject/studentName/{name}")
    public List<String> getSubjectListByStudentName(@PathVariable("name") String name) {
        return studentSubjectService.getSubjectListByStudentName(name);
    }

    //todo: getting all details of subjects through student name
//    @GetMapping("/studentSubject/student/{name}")
//    public List<SubjectEntity> getSubjectEntityListByStudentName(@PathVariable("name") String name) {
//        return studentSubjectService.getSubjectEntityListByStudentName(name);
//    }

    // getting student list Details through subject name
    @GetMapping("/studentSubject/subjectName/{name}")
    public List<StudentEntity> getStudentListBySubjectName(@PathVariable("name") String name) {
        return studentSubjectService.getStudentListBySubjectName(name);
    }

}
