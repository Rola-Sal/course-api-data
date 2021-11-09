package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //we will link it to database
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
       List<Course> courses = new ArrayList<Course>();
       courseRepository.findByTopicId(topicId)
               .forEach(courses :: add);
       return courses;
    }

    public Optional<Course> getCourse(String id){
        return courseRepository.findById(id);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course); //the same as create new topic it will search by id first
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
