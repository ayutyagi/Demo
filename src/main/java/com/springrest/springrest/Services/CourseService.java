package com.springrest.springrest.Services;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();
    public Course getCourseId(int Id);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(int id);


}
