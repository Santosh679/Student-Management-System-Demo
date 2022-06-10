package com.amtrix.college.service;

import com.amtrix.college.entity.SubjectEntity;
import com.amtrix.college.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    // getting a specific subject details
    public SubjectEntity getSubjectEntityById(Long id) {
         return subjectRepository.findById(id).get();
     }

     // getting all subject details
    public List<SubjectEntity> getAllSubjectEntity() {
         List<SubjectEntity> subjectEntities = new ArrayList<SubjectEntity>();
         subjectRepository.findAll().forEach(subjectEntity -> subjectEntities.add(subjectEntity));
         return subjectEntities;
    }

    // saving specific subject details
    public void saveOrUpdate(SubjectEntity subjectEntity) {
        subjectRepository.save(subjectEntity);
    }

    // deleting a specific subject details
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    // updating subject details
    public void update(SubjectEntity subjectEntity, long id) {
        subjectRepository.save(subjectEntity);
    }

    // find by Name
    public SubjectEntity findByName(String name) {
        return subjectRepository.findByName(name);
    }

}
