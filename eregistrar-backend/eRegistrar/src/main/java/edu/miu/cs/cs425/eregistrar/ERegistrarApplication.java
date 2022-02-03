package edu.miu.cs.cs425.eregistrar;

import edu.miu.cs.cs425.eregistrar.model.*;
import edu.miu.cs.cs425.eregistrar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ERegistrarApplication implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private AcademicBlockService academicBlockService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private BlockCourseService blockCourseService;

    @Autowired
    private CoursePrerequisiteService coursePrerequisiteService;

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @Autowired
    private RegistrationService registrationService;

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create 3 new Role
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("FACULTY");
        Role role3 = new Role("STUDENT");

        //Create 2 new address
        Address address1 = new Address("4", "Main street",
                "Fairfield", "52557", "USA", "(641) 123-1234", "asmith@google.com");
        Address address2 = new Address("15B", "West Burlington Avenue",
                "Portsmouth", "12012", "USA", "(123) 112-1230", "bjones@yahoo.co.uk");

        // Create 3 new user
        User u1 = new User("613473", "Md Anwar", "Hossain", "123456", address1);
        User u2 = new User("613474", "Tohfa", "Nusrat", "123456", address1);
        User u3 = new User("613478", "Faysal Hossain", "Mazed", "123456", address2);

        assignRoleToUser(role1, u1);
        assignRoleToUser(role2, u2);
        assignRoleToUser(role3, u3);

        // Create 3 new Academic Blocks
        AcademicBlock ab1 = new AcademicBlock("Sep-2021", "September 2021", LocalDate.of(2021,9,01), LocalDate.of(2021,9,30));
        AcademicBlock ab2 = new AcademicBlock("Oct-2021", "October 2021", LocalDate.of(2021,10,01), LocalDate.of(2021,10,31));
        AcademicBlock ab3 = new AcademicBlock("Nov-2021", "November 2021", LocalDate.of(2021,11,01), LocalDate.of(2021,11,30));

        // Create 3 new Courses
        Course course1 = new Course("CS390", "Fundamental Programming Practices", 3.0, 2.7);
        Course course2 = new Course("CS401", "Modern Programming Practices", 3.0, 2.7);
        Course course3 = new Course("CS523", "Big Data Technology", 2.3, 2.3);
        Course course4 = new Course("CS435", "Algorithms", 2.7, 2.3);

        AcademicBlock[] academicBlocks = {ab1, ab2, ab3};
        Course[] courses = {course1, course2, course3, course4};
        createAcademicBlock(academicBlocks);
        createCourses(courses);

        assignCoursesToAcademicBlock();
       //Create Student Request for Registration
       RegistrationRequest rr = new RegistrationRequest(1,
               academicBlockService.getAcademicBlockById(1L).get(), userService.getUserById(3L).get(),
               courseService.getCourseById(1L).get());
       registrationRequestService.save(rr);



    }

    private void assignRoleToUser(Role role, User user) {
           user.setRoles(List.of(roleService.save(role)));
           userService.save(user);
    }

    public void createAcademicBlock(AcademicBlock[] academicBlocks){
        for(AcademicBlock ab : academicBlocks) {
            academicBlockService.save(ab);
        }
    }

    public void createCourses(Course[] courses){
        for(Course c : courses) {
            courseService.save(c);
        }
    }

    private void assignCoursesToAcademicBlock() {
        AcademicBlock ab1 = academicBlockService.getAcademicBlockById(1L).get();
        //Create Block Course
        BlockCourse blockCourse1 = new BlockCourse(40, ab1,
                userService.getUserById(1L).get(),
                courseService.getCourseById(1L).get());
        BlockCourse blockCourse2 = new BlockCourse(30, ab1,
                userService.getUserById(2L).get(),
                courseService.getCourseById(2L).get());
        blockCourseService.save(blockCourse1);
        blockCourseService.save(blockCourse2);
    }
}
