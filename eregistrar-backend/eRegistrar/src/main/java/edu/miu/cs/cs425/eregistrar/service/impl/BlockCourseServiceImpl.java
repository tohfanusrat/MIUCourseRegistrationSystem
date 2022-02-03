package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.BlockCourse;
import edu.miu.cs.cs425.eregistrar.repository.BlockCourseRepository;
import edu.miu.cs.cs425.eregistrar.service.BlockCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockCourseServiceImpl implements BlockCourseService {

    @Autowired
    private BlockCourseRepository blockCourseRepository;

    @Override
    public List<BlockCourse> getAllBlockCourse() {
        return blockCourseRepository.findAll();
    }

    @Override
    public BlockCourse save(BlockCourse blockCourse) {
        return blockCourseRepository.save(blockCourse);
    }

    @Override
    public List<BlockCourse> getAllCourseByAcademicBlock(long blockId) {
        return blockCourseRepository.findAllCourseByAcademicBlock(blockId);
    }


}
