package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Coursedao extends JpaRepository<Course, Integer> {

    public Course findById(int Id);

}
