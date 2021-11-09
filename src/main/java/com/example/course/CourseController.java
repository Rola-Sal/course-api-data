package com.example.course;

import com.example.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class CourseController {
    @Autowired //to make a service dependency
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses") //get method as default
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}") // get specific topic by id
    public Optional<Course> getCourse(@PathVariable String id){ // @PathVariable this is the variable in the path
        return courseService.getCourse(id);
    }

    @RequestMapping(method = POST, value = "/topics/{topicId}/courses")//here we specified the method want to use , we determine the post body in postman
    public void addTopic(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.updateCourse(course);
    }

    @RequestMapping(method = DELETE,value = "/topics/{topicId}/courses/{id}")
    public void deleteCourses(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
