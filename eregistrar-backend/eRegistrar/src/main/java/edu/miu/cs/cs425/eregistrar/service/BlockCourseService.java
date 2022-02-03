package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.BlockCourse;
import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlockCourseService {
    public abstract List<BlockCourse> getAllBlockCourse();
    public abstract BlockCourse save(BlockCourse blockCourse);
    public abstract List<BlockCourse> getAllCourseByAcademicBlock(long blockId);
}
