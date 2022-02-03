package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.CoursePrerequisite;
import edu.miu.cs.cs425.eregistrar.repository.BlockCourseRepository;
import edu.miu.cs.cs425.eregistrar.repository.CoursePrerequisiteRepository;
import edu.miu.cs.cs425.eregistrar.service.CoursePrerequisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursePrerequisiteServiceImpl implements CoursePrerequisiteService {

    @Autowired
    private CoursePrerequisiteRepository coursePrerequisiteRepository;

    @Override
    public List<CoursePrerequisite> getAllCoursePrerequisite() {
        return coursePrerequisiteRepository.findAll();
    }

    @Override
    public CoursePrerequisite save(CoursePrerequisite coursePrerequisite) {
        return coursePrerequisiteRepository.save(coursePrerequisite);
    }

    @Override
    public Optional<CoursePrerequisite> findCoursePrerequisiteById(Long id) {
        return coursePrerequisiteRepository.findById(id);
    }
}
