package edu.miu.cs.cs425.eregistrar.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "block_courses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BlockCourse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_course_id")
    private Long blockCourseId;
    @NotNull
    private Integer capacity;
    @ManyToOne()
    @JoinColumn(name = "academic_block_id", nullable = true)
    private AcademicBlock academicBlock;
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public BlockCourse() {
        // This constructor is for Hibernate's use only
    }

    public BlockCourse(Long blockCourseId, Integer capacity, AcademicBlock academicBlock, User user, Course course) {
        this.blockCourseId = blockCourseId;
        this.capacity = capacity;
        this.academicBlock = academicBlock;
        this.user = user;
        this.course = course;
    }

    public BlockCourse(Integer capacity, AcademicBlock academicBlock, User user, Course course) {
        this.capacity = capacity;
        this.academicBlock = academicBlock;
        this.user = user;
        this.course = course;
    }

    public Long getBlockCourseId() {
        return blockCourseId;
    }

    public void setBlockCourseId(Long blockCourseId) {
        this.blockCourseId = blockCourseId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

//    public AcademicBlock getAcademicBlock() {
//        return academicBlock;
//    }

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
        if (!(o instanceof BlockCourse)) return false;
        BlockCourse that = (BlockCourse) o;
        return Objects.equals(blockCourseId, that.blockCourseId) && Objects.equals(capacity, that.capacity) && Objects.equals(academicBlock, that.academicBlock) && Objects.equals(user, that.user) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockCourseId, capacity, academicBlock, user, course);
    }

    @Override
    public String toString() {
        return "BlockCourse{" +
                "blockCourseId=" + blockCourseId +
                ", capacity=" + capacity +
                ", academicBlock=" + academicBlock +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
}
