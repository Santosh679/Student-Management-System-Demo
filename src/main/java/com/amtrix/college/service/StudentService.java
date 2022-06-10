package com.amtrix.college.service;

import com.amtrix.college.entity.StudentEntity;
import com.amtrix.college.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // getting a specific studentEntity
    public StudentEntity getStudentEntityById(Long id) {
        return studentRepository.findById(id).get();
    }


    // getting all studentEntity
    public List<StudentEntity> getAllStudentEntity() {
        List<StudentEntity> studentEntities = new ArrayList<StudentEntity>();
        studentRepository.findAll().forEach(studentEntity -> studentEntities.add(studentEntity));
        return studentEntities;
    }

    // saving a specific student details
    public void saveOrUpdate(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }

    // deleting a specific student details
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    // updating students details
    public void update(StudentEntity studentEntity, long id) {
        studentRepository.save(studentEntity);
    }

    public StudentEntity findByName(String name) {
        return studentRepository.findByName(name);
    }

}
