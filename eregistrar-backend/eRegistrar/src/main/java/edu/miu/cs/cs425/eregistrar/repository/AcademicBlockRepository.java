package edu.miu.cs.cs425.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.model.AcademicBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicBlockRepository extends JpaRepository<AcademicBlock, Long> {

    @Modifying
    @Query("UPDATE AcademicBlock ab set ab = ?1 where ab.blockId = ?2")
    void update(AcademicBlock academicBlock, long id);
}
