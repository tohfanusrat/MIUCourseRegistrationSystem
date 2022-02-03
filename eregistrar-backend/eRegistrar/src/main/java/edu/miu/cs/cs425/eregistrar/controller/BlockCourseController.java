package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.BlockCourse;
import edu.miu.cs.cs425.eregistrar.service.BlockCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/eregistrar/api/course-block-management"})
public class BlockCourseController {

    @Autowired
    private BlockCourseService blockCourseService;

    @GetMapping(value = {"/list/{blockId}"})
    public List<BlockCourse> getAllBlockCoursesUser(@PathVariable("blockId") long blockId){
        return blockCourseService.getAllCourseByAcademicBlock(blockId);
    }
}
