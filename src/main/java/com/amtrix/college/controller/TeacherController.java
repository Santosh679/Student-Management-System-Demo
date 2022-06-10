package com.amtrix.college.controller;

import com.amtrix.college.entity.TeacherEntity;
import com.amtrix.college.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    // mapping to retrieves a specific teacher details
    @GetMapping("/teacher/{id}")
    private TeacherEntity getTeacherEntity(@PathVariable("id") long id) {
        return teacherService.getTeacherEntityById(id);
    }

    @GetMapping("/teacher/id")
    private TeacherEntity getTeacherByRequestParam(@PathParam("id") long id) {
        return teacherService.getTeacherEntityById(id);
    }

    // mapping to retrieves all teacher details
    @GetMapping("/teacher")
    private List<TeacherEntity> getAllTeacherEntity() {
        return teacherService.getAllTeacherEntity();
    }

    // mapping to delete a specific teacher details
    @DeleteMapping("/teacher/{id}")
    private void deleteTeacherEntity(@PathVariable("id") long id) {
        teacherService.delete(id);
    }

    // mapping to post the teacher details
    @PostMapping("/teacher")
    private String saveTeacherEntity(@RequestBody TeacherEntity teacherEntity) {

//        Check name -> exist or not
        TeacherEntity databaseTeacherEntity = teacherService.findByName(teacherEntity.getName());
        if (databaseTeacherEntity != null) {
            return databaseTeacherEntity.getName() + " already Exist";
        } else {
            teacherService.saveOrUpdate(teacherEntity);
            return "Successfully Saved";
        }
    }

    // mapping to put the teacher details
    @PostMapping("/teacher/update")
    private String update(@RequestBody TeacherEntity teacherEntity) {
//        teacherService.saveOrUpdate(teacherEntity);
//        return teacherEntity;

        // Check id -> exist or not
        TeacherEntity databaseTeacherEntity = teacherService.getTeacherEntityById(teacherEntity.getId());
        if (databaseTeacherEntity != null) {
            teacherService.saveOrUpdate(teacherEntity);
            return "Updated";
        } else {
            teacherService.saveOrUpdate(teacherEntity);
            return "Saved with new ID";
        }

//        teacherService.saveOrUpdate(teacherEntity);
//        return "done";
    }
}
