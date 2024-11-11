package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{studentId}")
    public String viewStudent(Model model, @PathVariable("studentId") String id) {
        Student student = studentRepository.getStudent(id);
        student = Student.constructPasswordMaskedUser(student);
        model.addAttribute("student", student);
        return "studentView";
    }

    // 점수와 평가 항목을 제외하고 정보를 출력하는 메서드
    @GetMapping(value = "/{studentId}", params = "hideScore=yes")
    public String getStudentWithoutScore(@PathVariable String studentId,
                                         Model model) {
        Student student = studentRepository.getStudent(studentId);
        student = Student.constructScoreAndCommentMaskedUser(student);
        model.addAttribute("student", student);
        return "studentView"; // 점수와 평가 항목을 제외하는 뷰
    }
}
