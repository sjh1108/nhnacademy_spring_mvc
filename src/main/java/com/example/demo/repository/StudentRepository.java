package com.example.demo.repository;


import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
    boolean exists(String id);

    Student register(String name, String email, int score, String comment);

    Student getStudent(String id);

    boolean matches(String id, String password);

    Student addStudent(String id, String password, String name, String email, int score, String comment);


    Student addStudent(Student student);

    void modifyStudent(Student student);
}