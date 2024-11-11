package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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
        model.addAttribute("student", student);
        return "studentView";
    }
    // 점수와 평가 항목을 제외하고 정보를 출력하는 메서드
//    @GetMapping("/{studentId}")
//    public String getStudentWithoutScore(@PathVariable String studentId,
//                                         @RequestParam(name = "hideScore", required = false) String hideScore,
//                                         Model model) {
//        if ("yes".equals(hideScore)) {
//            Student student = studentRepository.getStudent(studentId);
//            model.addAttribute("student", student);
//            model.addAttribute("hideScore", true); // 점수와 평가를 제외하도록 설정
//            return "studentView"; // 점수와 평가 항목을 제외하는 뷰
//        }
//        return "studentView";
//    }
//
//    @GetMapping("/{studentId}/modify")
//    public String studentModifyForm() {
//        return "studentModify";
//    }
//
//    @PostMapping("/{studentId}/modify")
//    public String modifyUser() {
//        return "studentView";
//    }

}
