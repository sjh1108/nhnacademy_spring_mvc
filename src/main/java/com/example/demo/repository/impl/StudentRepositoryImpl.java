package com.example.demo.repository.impl;

import com.example.demo.repository.StudentRepository;
import com.example.demo.domain.Student;
import com.example.demo.exception.StudentAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final Map<String, Student> studentMap = new HashMap<>();

    public StudentRepositoryImpl() {
        studentMap.put("a",Student.create("a","a","a",
                "mail@mail.com","100","good"));
    }
    @Override
    public boolean exists(String id) {
        return studentMap.containsKey(id);
    }

    @Override
    public Student getStudent(String id) {
        return studentMap.get(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getStudent(id))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    @Override
    public Student addStudent(String id, String password, String name, String email, String score, String comment) {
        if (exists(id)) {
            throw new StudentAlreadyExistsException();
        }
        studentMap.put(id, new Student(id, password, name, email, score, comment));

        return Student.create(id,password,name,email,score,comment);
    }

    @Override
    public void addStudent(Student student) {
        if (exists(student.getId())) {
            throw new StudentAlreadyExistsException();
        }
        studentMap.put(student.getId(), student);
        System.out.println("repositroy addstudent id, pwd"+student.getId()+", "+student.getPassword());
    }

    @Override
    public void modifyStudent(Student student) {
        studentMap.remove(student.getId());
        studentMap.put(student.getId(), student);
    }
}
