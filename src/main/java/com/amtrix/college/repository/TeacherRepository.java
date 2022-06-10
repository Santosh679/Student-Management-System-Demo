package com.amtrix.college.repository;

import com.amtrix.college.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    TeacherEntity findByName(String name);
}
