package edu.miu.cs.cs425.eregistrar.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "course_prerequisites")
public class CoursePrerequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_prerequisite_id")
    private Long coursePrerequisiteId;
    @NotNull
    private Double passGradePoint;
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "course_id", nullable = true)
//    private Course course;
//    @OneToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "course_id", nullable = false)
//    private Course prerequisiteCourse;


    public CoursePrerequisite() {
        // This constructor is for Hibernate's use only
    }

//    public CoursePrerequisite(Long coursePrerequisiteId, Double passGradePoint, Course course, Course prerequisiteCourse) {
//        this.coursePrerequisiteId = coursePrerequisiteId;
//        this.passGradePoint = passGradePoint;
//        this.course = course;
//        this.prerequisiteCourse = prerequisiteCourse;
//    }
//
//    public CoursePrerequisite(Double passGradePoint, Course course, Course prerequisiteCourse) {
//        this.passGradePoint = passGradePoint;
//        this.course = course;
//        this.prerequisiteCourse = prerequisiteCourse;
//    }
//
//    public Long getCoursePrerequisiteId() {
//        return coursePrerequisiteId;
//    }
//
//    public void setCoursePrerequisiteId(Long coursePrerequisiteId) {
//        this.coursePrerequisiteId = coursePrerequisiteId;
//    }
//
//    public Double getPassGradePoint() {
//        return passGradePoint;
//    }
//
//    public void setPassGradePoint(Double passGradePoint) {
//        this.passGradePoint = passGradePoint;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//
//    public Course getPrerequisiteCourse() {
//        return prerequisiteCourse;
//    }
//
//    public void setPrerequisiteCourse(Course prerequisiteCourse) {
//        this.prerequisiteCourse = prerequisiteCourse;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CoursePrerequisite)) return false;
//        CoursePrerequisite that = (CoursePrerequisite) o;
//        return Objects.equals(coursePrerequisiteId, that.coursePrerequisiteId) && Objects.equals(passGradePoint, that.passGradePoint) && Objects.equals(course, that.course) && Objects.equals(prerequisiteCourse, that.prerequisiteCourse);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(coursePrerequisiteId, passGradePoint, course, prerequisiteCourse);
//    }
//
//    @Override
//    public String toString() {
//        return "CoursePrerequisite{" +
//                "coursePrerequisiteId=" + coursePrerequisiteId +
//                ", passGradePoint=" + passGradePoint +
//                ", course=" + course +
//                ", prerequisiteCourse=" + prerequisiteCourse +
//                '}';
//    }
}
