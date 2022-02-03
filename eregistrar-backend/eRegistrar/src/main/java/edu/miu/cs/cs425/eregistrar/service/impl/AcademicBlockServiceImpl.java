package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.AcademicBlock;
import edu.miu.cs.cs425.eregistrar.model.User;
import edu.miu.cs.cs425.eregistrar.repository.AcademicBlockRepository;
import edu.miu.cs.cs425.eregistrar.service.AcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicBlockServiceImpl implements AcademicBlockService {

    @Autowired
    private AcademicBlockRepository academicBlockRepository;

    @Override
    public List<AcademicBlock> getAllAcademicBlock() {
        return academicBlockRepository.findAll();
    }

    @Override
    public AcademicBlock save(AcademicBlock academicBlock) {
           return academicBlockRepository.save(academicBlock);
    }

    @Override
    public Optional<AcademicBlock> getAcademicBlockById(Long id) {
        return academicBlockRepository.findById(id);
    }

    @Override
    public void deleteAcademicBlockById(Long blockId) {
        academicBlockRepository.deleteById(blockId);
    }
}
