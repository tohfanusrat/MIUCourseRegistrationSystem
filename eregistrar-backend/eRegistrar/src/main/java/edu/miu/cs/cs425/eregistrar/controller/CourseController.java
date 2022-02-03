package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Course;
import edu.miu.cs.cs425.eregistrar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/eregistrar/api/course-management"})
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = {"/list"})
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }
}
