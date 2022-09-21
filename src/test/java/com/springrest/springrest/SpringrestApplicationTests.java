package com.springrest.springrest;


import com.springrest.springrest.Services.CourseServiceImp;
import com.springrest.springrest.dao.Coursedao;
import com.springrest.springrest.entities.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
 public class SpringrestApplicationTests {


    @InjectMocks
    private CourseServiceImp service;

    @Mock
    private Coursedao repository;


    @Test
    public void getAllCourseTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new Course(1,"java","Programming Language"),new Course(2,"django","Framework")).collect(Collectors.toList()));
        assertEquals(2,service.getCourses().size());
    }


    @Test
    public void addCourseTest() {
        Course course=new Course(2,"Maths","problem-solving");
        when(repository.save(course)).thenReturn(course);
        assertEquals(course,service.addCourse(course));
    }

    @Test
    public void deleteCourseTest() {
        Course course=new Course(333,"rajhkjni","wjkr");
        when(repository.getReferenceById(333)).thenReturn(course);
        service.deleteCourse(333);
        verify(repository,times(1)).delete(course);
    }




    @Test
    public void getCourseByIdTest() {
        Course course=new Course(4,"Science","Technology");
        when(repository.findById(4)).thenReturn(course);
        Course actualResult = service.getCourseId(4);
        assertEquals(course,actualResult);

    }



}
