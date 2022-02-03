package edu.miu.cs.cs425.eregistrar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "academic_blocks")
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academic_block_id")
    private Long blockId;
    @NotNull
    private String blockCode;
    @NotNull
    private String blockTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @OneToMany(mappedBy = "academicBlock", cascade = CascadeType.ALL)
    private List<BlockCourse> blockCourses = new ArrayList<>();

    public AcademicBlock() {
        // This constructor is for Hibernate's use only
    }

    public AcademicBlock(Long blockId, String blockCode, String blockTitle, LocalDate startDate, LocalDate endDate) {
        this.blockId = blockId;
        this.blockCode = blockCode;
        this.blockTitle = blockTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AcademicBlock(String blockCode, String blockTitle, LocalDate startDate, LocalDate endDate) {
        this.blockCode = blockCode;
        this.blockTitle = blockTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AcademicBlock(String blockCode, String blockTitle, LocalDate startDate, LocalDate endDate, List<BlockCourse> blockCourses) {
        this.blockCode = blockCode;
        this.blockTitle = blockTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.blockCourses = blockCourses;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getBlockTitle() {
        return blockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<BlockCourse> getBlockCourses() {
        return blockCourses;
    }

    public void setBlockCourses(List<BlockCourse> blockCourses) {
        this.blockCourses = blockCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcademicBlock)) return false;
        AcademicBlock that = (AcademicBlock) o;
        return Objects.equals(blockId, that.blockId) && Objects.equals(blockCode, that.blockCode) && Objects.equals(blockTitle, that.blockTitle) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(blockCourses, that.blockCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockId, blockCode, blockTitle, startDate, endDate, blockCourses);
    }

    @Override
    public String toString() {
        return "AcademicBlock{" +
                "blockId=" + blockId +
                ", blockCode='" + blockCode + '\'' +
                ", blockTitle='" + blockTitle + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", blockCourses=" + blockCourses +
                '}';
    }
}
