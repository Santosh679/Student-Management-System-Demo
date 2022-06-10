package com.amtrix.college.controller;

import com.amtrix.college.entity.StudentEntity;
import com.amtrix.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Lob;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class StudentController {

    @Autowired

    StudentService studentService;



    // get mapping that retrieves all the students details
    @GetMapping("/student")
    private List<StudentEntity> getAllStudentEntity() {
        return studentService.getAllStudentEntity();
    }

    // get mapping that retrieves the details of a specific students details
    @GetMapping("/student/{id}")
    private StudentEntity getStudentEntity(@PathVariable("id") long id) {
        return studentService.getStudentEntityById(id);
    }

    // delete mapping that deletes a specified students details
    @DeleteMapping("/student/{id}")
    private void deleteStudentEntity(@PathVariable("id") long id) {
        studentService.delete(id);
    }

    // post mapping that post the student details
    @PostMapping("/student")
    private long saveStudentEntity(@RequestBody StudentEntity studentEntity) throws ParseException {
//        StudentEntity databaseStudentEntity = studentService.findByName(studentEntity.getName());
//        if(databaseStudentEntity != null )
//        {
//            return -1L;
//        } else {

//        Date todayDate = new Date();
//        Calendar todayCalenderDate = Calendar.getInstance();
//        Date date = studentEntity.getDob();
        // convert into string
//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = dateFormat.format(date);
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date dob = formatter.parse(strDate);
//
//        //Converting obtained Date object to LocalDate object
//        Instant instant = dob.toInstant();
//        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
//        LocalDate birthday = zone.toLocalDate();
//
//        LocalDate today = LocalDate.now();
//        Period p = Period.between(birthday, today);

//        String age = p.getYears() + " years " + p.getMonths() + " months " + p.getDays() + " days";


        Calendar nowdate = Calendar.getInstance();


        Calendar dob = Calendar.getInstance();
        dob.setTime(studentEntity.getDob());

        Long days = TimeUnit.MILLISECONDS.toDays(Math.abs(nowdate.getTimeInMillis() - dob.getTimeInMillis()));


        long years = days / 365;
        long rem = days % 365;
        long months = rem / 31;
        long days1 = rem % 31;




        studentEntity.setAge(years + " Years " + months + " Months " + days1 + " Days");
            studentService.saveOrUpdate(studentEntity);
            return studentEntity.getId();

//        }
    }

    // put mapping that updates the students details
    @PutMapping("/student")
    private StudentEntity update(@RequestBody StudentEntity studentEntity) {
        studentService.saveOrUpdate(studentEntity);
        return studentEntity;
    }

}
