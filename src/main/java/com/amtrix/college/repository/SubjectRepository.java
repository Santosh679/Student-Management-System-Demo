package com.amtrix.college.repository;

import com.amtrix.college.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    SubjectEntity findByName(String name);
}
