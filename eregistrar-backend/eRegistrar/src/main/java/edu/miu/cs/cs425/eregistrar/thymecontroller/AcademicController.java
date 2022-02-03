package edu.miu.cs.cs425.eregistrar.thymecontroller;

import edu.miu.cs.cs425.eregistrar.model.AcademicBlock;
import edu.miu.cs.cs425.eregistrar.service.AcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/eregistrar/academic-block"})
public class AcademicController {

    @Autowired
    private AcademicBlockService academicBlockService;

    @GetMapping(value = {"/list"})
    public ModelAndView getAcademicBlocks(){
        var modelAndView = new ModelAndView();
        if (academicBlockService.getAllAcademicBlock() != null){
            modelAndView.addObject("academicBlocks", academicBlockService.getAllAcademicBlock());
            modelAndView.setViewName("block/list");
            return modelAndView;
        }else{
            modelAndView.addObject("academicBlockCount", 0);
            modelAndView.setViewName("block/list");
            return modelAndView;
        }
    }

    @GetMapping(value = {"/course/{blockId}"})
    public ModelAndView getCoursesByAcademicBlockId(@PathVariable("blockId") long blockId){
        var modelAndView = new ModelAndView();
        var academicBlock = academicBlockService.getAcademicBlockById(blockId).get();
        modelAndView.addObject("courses", academicBlock.getBlockCourses());
        modelAndView.setViewName("course/list");
        return modelAndView;
    }

    @PostMapping(value = {"/create"})
    public String createAcademicBlock(@Valid @RequestBody AcademicBlock academicBlock){
        return "";
    }

    @GetMapping(value = {"/delete/{blockId}"})
    public String deleteBlock(@PathVariable("blockId") Long blockId) {
        academicBlockService.deleteAcademicBlockById(blockId);
        return "redirect:/eregistrar/academic-block/list";
    }
}
