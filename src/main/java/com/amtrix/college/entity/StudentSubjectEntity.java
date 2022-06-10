package com.amtrix.college.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class StudentSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private StudentEntity studentEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    private SubjectEntity subjectEntity;
}
