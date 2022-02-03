package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.CoursePrerequisite;
import edu.miu.cs.cs425.eregistrar.model.RegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CoursePrerequisiteService {
    public abstract List<CoursePrerequisite> getAllCoursePrerequisite();
    public abstract CoursePrerequisite save(CoursePrerequisite coursePrerequisite);
    public abstract Optional<CoursePrerequisite> findCoursePrerequisiteById(Long id);
}
