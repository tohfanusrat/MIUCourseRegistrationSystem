package edu.miu.cs.cs425.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.model.BlockCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockCourseRepository extends JpaRepository<BlockCourse, Long> {

    @Query("SELECT bc FROM BlockCourse bc where bc.academicBlock.blockId = ?1")
    List<BlockCourse> findAllCourseByAcademicBlock(long blockId);
}
