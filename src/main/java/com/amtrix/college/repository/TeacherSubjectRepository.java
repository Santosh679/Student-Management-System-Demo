package com.amtrix.college.repository;

import com.amtrix.college.entity.TeacherSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherSubjectRepository extends JpaRepository<TeacherSubjectEntity, Long> {


    List<TeacherSubjectEntity> findByTeacherEntityName(String name);

    List<TeacherSubjectEntity> findBySubjectEntityName(String name);

}
