package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.AcademicBlock;
import edu.miu.cs.cs425.eregistrar.model.Course;
import edu.miu.cs.cs425.eregistrar.model.RegistrationRequest;
import edu.miu.cs.cs425.eregistrar.model.User;
import edu.miu.cs.cs425.eregistrar.model.request.RegistrationRequestBody;
import edu.miu.cs.cs425.eregistrar.model.response.RegistrationResponse;
import edu.miu.cs.cs425.eregistrar.service.AcademicBlockService;
import edu.miu.cs.cs425.eregistrar.service.CourseService;
import edu.miu.cs.cs425.eregistrar.service.RegistrationRequestService;
import edu.miu.cs.cs425.eregistrar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/eregistrar/api/registration-request-management"})
public class RegistrationRequestController {

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @Autowired
    private AcademicBlockService academicBlockService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<RegistrationResponse> addNewStudent(@Valid @RequestBody RegistrationRequestBody registrationRequest) {
        RegistrationResponse response = new RegistrationResponse("Registration request successfully created!");
        AcademicBlock academicBlock = academicBlockService.getAcademicBlockById(registrationRequest.getAcademicBlockId()).get();
        Course course = courseService.getCourseById(registrationRequest.getCourseId()).get();
        User user = userService.getUserById(registrationRequest.getUserId()).get();
        RegistrationRequest rr = new RegistrationRequest(registrationRequest.getPriorityIndex(),academicBlock, user, course);
        registrationRequestService.save(rr);
        return ResponseEntity.of(Optional.of(response));
    }
}
