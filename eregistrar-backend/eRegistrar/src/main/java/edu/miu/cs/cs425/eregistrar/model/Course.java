package edu.miu.cs.cs425.eregistrar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "courses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @NotNull
    private String courseCode;
    @NotNull
    private String courseTitle;
    @NotNull
    private Double passGradePoint;
    @NotNull
    private Double retakeableGradePoint;
    public Course() {
        // This constructor is for Hibernate's use only
    }

    public Course(Long courseId, String courseCode, String courseTitle, Double passGradePoint, Double retakeableGradePoint) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.passGradePoint = passGradePoint;
        this.retakeableGradePoint = retakeableGradePoint;
    }

    public Course(String courseCode, String courseTitle, Double passGradePoint, Double retakeableGradePoint) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.passGradePoint = passGradePoint;
        this.retakeableGradePoint = retakeableGradePoint;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Double getPassGradePoint() {
        return passGradePoint;
    }

    public void setPassGradePoint(Double passGradePoint) {
        this.passGradePoint = passGradePoint;
    }

    public Double getRetakeableGradePoint() {
        return retakeableGradePoint;
    }

    public void setRetakeableGradePoint(Double retakeableGradePoint) {
        this.retakeableGradePoint = retakeableGradePoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(courseCode, course.courseCode) && Objects.equals(courseTitle, course.courseTitle) && Objects.equals(passGradePoint, course.passGradePoint) && Objects.equals(retakeableGradePoint, course.retakeableGradePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseCode, courseTitle, passGradePoint, retakeableGradePoint);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", passGradePoint=" + passGradePoint +
                ", retakeableGradePoint=" + retakeableGradePoint +
                '}';
    }
}
