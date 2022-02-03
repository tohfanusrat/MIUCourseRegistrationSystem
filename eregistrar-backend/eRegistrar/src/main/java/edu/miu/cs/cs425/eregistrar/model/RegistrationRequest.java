package edu.miu.cs.cs425.eregistrar.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "registration_requests")
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_request_id")
    private Long coursePrerequisiteId;
    @NotNull
    private Integer priorityIndex;
    @ManyToOne()
    @JoinColumn(name = "academic_block_id", nullable = false)
    private AcademicBlock academicBlock;
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne()
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;


    public RegistrationRequest() {
        // This constructor is for Hibernate's use only
    }

    public RegistrationRequest(Long coursePrerequisiteId, Integer priorityIndex, AcademicBlock academicBlock, User user, Course course) {
        this.coursePrerequisiteId = coursePrerequisiteId;
        this.priorityIndex = priorityIndex;
        this.academicBlock = academicBlock;
        this.user = user;
        this.course = course;
    }

    public RegistrationRequest(Integer priorityIndex, AcademicBlock academicBlock, User user, Course course) {
        this.priorityIndex = priorityIndex;
        this.academicBlock = academicBlock;
        this.user = user;
        this.course = course;
    }

    public Long getCoursePrerequisiteId() {
        return coursePrerequisiteId;
    }

    public void setCoursePrerequisiteId(Long coursePrerequisiteId) {
        this.coursePrerequisiteId = coursePrerequisiteId;
    }

    public Integer getPriorityIndex() {
        return priorityIndex;
    }

    public void setPriorityIndex(Integer priorityIndex) {
        this.priorityIndex = priorityIndex;
    }

    public AcademicBlock getAcademicBlock() {
        return academicBlock;
    }

    public void setAcademicBlock(AcademicBlock academicBlock) {
        this.academicBlock = academicBlock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationRequest)) return false;
        RegistrationRequest that = (RegistrationRequest) o;
        return Objects.equals(coursePrerequisiteId, that.coursePrerequisiteId) && Objects.equals(priorityIndex, that.priorityIndex) && Objects.equals(academicBlock, that.academicBlock) && Objects.equals(user, that.user) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coursePrerequisiteId, priorityIndex, academicBlock, user, course);
    }

    @Override
    public String toString() {
        return "RegistrationRequestBody{" +
                "coursePrerequisiteId=" + coursePrerequisiteId +
                ", priorityIndex=" + priorityIndex +
                ", academicBlock=" + academicBlock +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
}
