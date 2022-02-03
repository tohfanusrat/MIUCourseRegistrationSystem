package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.AcademicBlock;
import edu.miu.cs.cs425.eregistrar.model.Course;
import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    public abstract List<Course> getAllCourse();
    public abstract Course save(Course course);
    public abstract Optional<Course> getCourseById(Long id);
}
