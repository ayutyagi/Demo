package com.springrest.springrest.Services;

import com.springrest.springrest.dao.Coursedao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private Coursedao coursedao;



    List<Course> list;


    public CourseServiceImp() {
//        list = new ArrayList<>();
//        list.add(new Course(1, "Maths", "Easy course"));
//        list.add(new Course(2, "English", "Medium course"));
    }

    @Override
    public List<Course> getCourses() {
//        return list;
      return   coursedao.findAll();
    }

    @Override
    public Course getCourseId(int Id) {
//        Course ca = null;
//
//        for (Course course : list) {
//            if (course.getId() == Id) {
//                ca = course;
//                break;
//            }
//        }
//            return ca;

       return coursedao.findById(Id);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
//        return course;
        coursedao.save(course);
        return course;
    }

@Override
    public Course updateCourse(Course course){

//        list.forEach(e ->{
//            if(e.getId() == course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
//        return course;
    coursedao.save(course);
    return course;

    }
@Override
    public void deleteCourse(int id){
//        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());

    Course entity = coursedao.getReferenceById(id);
    coursedao.delete(entity);
    }

}