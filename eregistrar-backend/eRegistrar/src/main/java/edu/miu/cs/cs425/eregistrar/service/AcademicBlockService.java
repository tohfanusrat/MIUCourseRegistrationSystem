package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.AcademicBlock;
import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AcademicBlockService {
    public abstract List<AcademicBlock> getAllAcademicBlock();
    public abstract AcademicBlock save(AcademicBlock academicBlock);
    public abstract Optional<AcademicBlock> getAcademicBlockById(Long id);
    public abstract void deleteAcademicBlockById(Long blockId);
}
