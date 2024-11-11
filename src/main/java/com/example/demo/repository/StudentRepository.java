package com.example.demo.repository;


import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
    boolean exists(String id);

    Student getStudent(String id);

    boolean matches(String id, String password);

    Student addStudent(String id, String password, String name, String email, String score, String comment);


    void addStudent(Student student);

    void modifyStudent(Student student);
}