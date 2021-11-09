package com.example.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> { //<class name, type of id> لحتى نطبق الCRUD methods عليها

    //if you want a method to get course by name
    // you don't want to implement the method
    //JPA will implement the method for you
    //just declare the method with findByName
    //يعني اتبعي تسمية حسب تسمية الكلاس نفسها

    public List<Course> findByName(String name);
    public List<Course> findByDescription(String description);

    public List<Course> findByTopicId(String topicId); //search about matching topic entity in course then entity id in topic class


}
