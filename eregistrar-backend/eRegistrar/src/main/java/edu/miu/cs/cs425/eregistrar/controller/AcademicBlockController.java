package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.*;
import edu.miu.cs.cs425.eregistrar.model.request.BlockCourseRequest;
import edu.miu.cs.cs425.eregistrar.model.request.RegistrationRequestBody;
import edu.miu.cs.cs425.eregistrar.model.response.RegistrationResponse;
import edu.miu.cs.cs425.eregistrar.service.AcademicBlockService;
import edu.miu.cs.cs425.eregistrar.service.BlockCourseService;
import edu.miu.cs.cs425.eregistrar.service.CourseService;
import edu.miu.cs.cs425.eregistrar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/eregistrar/api/academic-block-management"})
public class AcademicBlockController {

    @Autowired
    private AcademicBlockService academicBlockService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private BlockCourseService blockCourseService;

    @GetMapping(value = {"/list"})
    public List<AcademicBlock> getAllAcademicBlock(){
        return academicBlockService.getAllAcademicBlock();
    }

    @PostMapping(value = {"/create"})
    public ResponseEntity<RegistrationResponse> addNewStudent(@Valid @RequestBody AcademicBlock academicBlock) {
        RegistrationResponse response = new RegistrationResponse("Academic block successfully created!");
        academicBlockService.save(academicBlock);
        return ResponseEntity.of(Optional.of(response));
    }

    @PostMapping(value = {"/course-assign"})
    public ResponseEntity<RegistrationResponse> assignCoursesToAcademicBlock(@Valid @RequestBody BlockCourseRequest blockCourseRequest) {
        RegistrationResponse response = new RegistrationResponse("Course assign to academic block successfully!");
        Course course = courseService.getCourseById(blockCourseRequest.getCourseId()).get();
        User faculty = userService.getUserById(blockCourseRequest.getFacultyId()).get();
        AcademicBlock ab = academicBlockService.getAcademicBlockById(blockCourseRequest.getAcademicBlockId()).get();
        BlockCourse bc = new BlockCourse(blockCourseRequest.getCapacity(), ab, faculty, course);
        blockCourseService.save(bc);
        return ResponseEntity.of(Optional.of(response));
    }
}
