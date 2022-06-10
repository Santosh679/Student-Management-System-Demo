package com.amtrix.college.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class TeacherSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private TeacherEntity teacherEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    private SubjectEntity subjectEntity;

}
