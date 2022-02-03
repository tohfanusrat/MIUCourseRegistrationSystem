package edu.miu.cs.cs425.eregistrar.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;
    @NotNull
    private String grade;
    @NotNull
    private Double gradePoint;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "academic_block_id", nullable = false)
    private AcademicBlock academicBlock;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;


    public Registration() {
        // This constructor is for Hibernate's use only
    }

    public Registration(Long registrationId, String grade, Double gradePoint, AcademicBlock academicBlock, User user, Course course) {
        this.registrationId = registrationId;
        this.grade = grade;
        this.gradePoint = gradePoint;
        this.academicBlock = academicBlock;
        this.user = user;
        this.course = course;
    }

    public Registration(String grade, Double gradePoint, AcademicBlock academicBlock, User user, Course course) {
        this.grade = grade;
        this.gradePoint = gradePoint;
        this.academicBlock = academicBlock;
        this.user = user;
        this.course = course;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(Double gradePoint) {
        this.gradePoint = gradePoint;
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
        if (!(o instanceof Registration)) return false;
        Registration that = (Registration) o;
        return Objects.equals(registrationId, that.registrationId) && Objects.equals(grade, that.grade) && Objects.equals(gradePoint, that.gradePoint) && Objects.equals(academicBlock, that.academicBlock) && Objects.equals(user, that.user) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId, grade, gradePoint, academicBlock, user, course);
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", grade='" + grade + '\'' +
                ", gradePoint=" + gradePoint +
                ", academicBlock=" + academicBlock +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
}
