package com.amtrix.college.repository;

import com.amtrix.college.entity.StudentSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubjectEntity, Long> {

//    StudentSubjectEntity findByStudentEntityName(String name);

    List<StudentSubjectEntity> findByStudentEntityName(String name);

    List<StudentSubjectEntity> findBySubjectEntityName(String name);
}
