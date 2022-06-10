package com.amtrix.college.service;

import com.amtrix.college.entity.StudentEntity;
import com.amtrix.college.entity.StudentSubjectEntity;
import com.amtrix.college.entity.SubjectEntity;
import com.amtrix.college.repository.StudentSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentSubjectService {

    @Autowired
    StudentSubjectRepository studentSubjectRepository;

    // saving studentsubject details
    public void saveOrUpdate(StudentSubjectEntity studentSubjectEntity) {
        studentSubjectRepository.save(studentSubjectEntity);
    }

    public StudentSubjectEntity getById(Long id) {
        return studentSubjectRepository.findById(id).orElse(null);
    }

    // todo: getting all subject details list through student name
    public List<String> getSubjectListByStudentName(String name) {
        List<StudentSubjectEntity> studentSubjectEntityList = studentSubjectRepository.findByStudentEntityName(name);
        List<String> responseList = new ArrayList<>();
        for (StudentSubjectEntity s: studentSubjectEntityList) {
            responseList.add(s.getSubjectEntity().getName());
        }
        return responseList;
    }

    //todo: getting all details of subject through student name
//    public List<SubjectEntity> getSubjectEntityListByStudentName(String name) {
//        List<StudentSubjectEntity> studentSubjectEntityList = studentSubjectRepository.findByStudentEntityName(name);
//        List<SubjectEntity> subjectEntityList = new ArrayList<>();
//        for (StudentSubjectEntity s: studentSubjectEntityList) {
//            subjectEntityList.add(s.getSubjectEntity());
//        }
//        return subjectEntityList;
//    }

    public List<StudentEntity> getStudentListBySubjectName(String name) {
        List<StudentSubjectEntity> studentSubjectEntityList = studentSubjectRepository.findBySubjectEntityName(name);
        List<StudentEntity> studentEntityList = new ArrayList<>();

        for (StudentSubjectEntity s: studentSubjectEntityList) {
            studentEntityList.add(s.getStudentEntity());
        }
        return studentEntityList;
    }

}

