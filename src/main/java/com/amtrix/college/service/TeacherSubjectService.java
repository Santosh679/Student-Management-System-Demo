package com.amtrix.college.service;

import com.amtrix.college.entity.StudentSubjectEntity;
import com.amtrix.college.entity.SubjectEntity;
import com.amtrix.college.entity.TeacherEntity;
import com.amtrix.college.entity.TeacherSubjectEntity;
import com.amtrix.college.repository.TeacherSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeacherSubjectService {

    @Autowired
    TeacherSubjectRepository teacherSubjectRepository;

    // saving teachersubject details
    public void saveOrUpdate(TeacherSubjectEntity teacherSubjectEntity) {
        teacherSubjectRepository.save(teacherSubjectEntity);
    }

    public TeacherSubjectEntity getById(long id) {
        return teacherSubjectRepository.findById((id)).orElse(null);
    }

    public List<SubjectEntity> getSubjectListByTeacherName(String name) {
        List<TeacherSubjectEntity> teacherSubjectEntityList = teacherSubjectRepository.findByTeacherEntityName(name);
        List<SubjectEntity> subjectEntityList = new ArrayList<>();

        for (TeacherSubjectEntity s : teacherSubjectEntityList) {
            subjectEntityList.add(s.getSubjectEntity());
        }
        return subjectEntityList;
    }

    public List<TeacherEntity> getTeacherListBySubjectName(String name) {
        List<TeacherSubjectEntity> teacherSubjectEntityList = teacherSubjectRepository.findBySubjectEntityName(name);
        List<TeacherEntity> teacherEntityList = new ArrayList<>();

        for (TeacherSubjectEntity s: teacherSubjectEntityList) {
            teacherEntityList.add(s.getTeacherEntity());
        }
        return teacherEntityList;
    }



}
