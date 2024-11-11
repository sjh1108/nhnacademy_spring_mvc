package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRegisterRequest;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student/modify")
public class StudentModifyController {
    private final StudentRepository studentRepository;

    public StudentModifyController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String studentModifyForm(@RequestParam("id") String studentId, Model model) {
        Student student = studentRepository.getStudent(studentId);
        model.addAttribute("student", student);
        return "studentModify";
    }

    @PostMapping
    public ModelAndView ModifyStudent(@ModelAttribute StudentRegisterRequest studentRequest) {

        Student student = new Student(studentRequest.getId(),studentRequest.getPassword(),
                studentRequest.getName(),studentRequest.getEmail(),studentRequest.getScore(),studentRequest.getComment());


        studentRepository.modifyStudent(student);

        ModelAndView modelAndView = new ModelAndView("redirect:/student/"+ student.getId());

        modelAndView.addObject("student", student);

        return modelAndView;
    }

}
