package com.amtrix.college.service;

import com.amtrix.college.entity.TeacherEntity;
import com.amtrix.college.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    // getting specific teacher details
    public TeacherEntity getTeacherEntityById(long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    // getting all teacher details
    public List<TeacherEntity> getAllTeacherEntity() {
        List<TeacherEntity> teacherEntities = new ArrayList<TeacherEntity>();
        teacherRepository.findAll().forEach(teacherEntity -> teacherEntities.add(teacherEntity));
        return teacherEntities;
    }

    // saving teacher details
    public void saveOrUpdate(TeacherEntity teacherEntity) {
        teacherRepository.save(teacherEntity);
    }

    // deleting specific teacher details
    public void delete(long id) {
        teacherRepository.deleteById(id);
    }

    // updating teacher details
    public void update(TeacherEntity teacherEntity, long id) {
        teacherRepository.save(teacherEntity);
    }

    // find by Name
    public TeacherEntity findByName(String name) {
        return teacherRepository.findByName(name);
    }
}
