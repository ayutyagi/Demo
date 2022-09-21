package com.springrest.springrest.controller;


import com.springrest.springrest.Services.CourseService;
import com.springrest.springrest.entities.Course;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class MyController {

    @Autowired
    private CourseService Service;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyController.class);

//    get all courses
    @GetMapping("/Course")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> list= Service.getCourses();
        try{
            logger.info("get all courses");
            return ResponseEntity.of(Optional.of(list));
        }catch(Exception e){
            logger.error("not getting all courses");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

//   get courses by using id
    @GetMapping("/course/{Id}")
    public Course getCourse(@PathVariable int Id) {

        return this.Service.getCourseId(Id);
    }

//    add course
       @PostMapping("/addcourse")
    public Course addCourse(@RequestBody Course course) {
        return this.Service.addCourse(course);
  }

//  update course
  @PutMapping("/updatecourse")
    public Course updateCourse(@RequestBody Course course) {

        return  this.Service.updateCourse(course);

  }
//  Delete a course
    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int courseId){
        try{
            logger.info("deleting course by Id");
            this.Service.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            logger.error("Something went wrong");
            System.out.println("lp");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




    }

