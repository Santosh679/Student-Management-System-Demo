package com.amtrix.college.repository;

import com.amtrix.college.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


    StudentEntity findByName(String name);
}
