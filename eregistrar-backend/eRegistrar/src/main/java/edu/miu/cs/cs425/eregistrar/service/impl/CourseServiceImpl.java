package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.AcademicBlock;
import edu.miu.cs.cs425.eregistrar.model.Course;
import edu.miu.cs.cs425.eregistrar.repository.CourseRepository;
import edu.miu.cs.cs425.eregistrar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
}
