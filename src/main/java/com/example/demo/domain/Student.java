package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String id;
    private String password;
    private String name;
    private String email;
    private String score;
    private String comment;

    public Student(String id, String password, String name, String email, String score, String comment) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.score = score;
        this.comment = comment;
    }

    public Student(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public static Student create(String id, String password, String name, String email, String score, String comment) {
        return new Student(id,password,name,email,score,comment);
    }

    public static Student create(String id, String password) {
        return new Student(id,password);
    }

    private static final String MASK = "*****";

    public static Student constructPasswordMaskedUser(Student student) {
        return Student.create(student.getId(), MASK, student.getName(), student.getEmail(), student.getScore(), student.getComment());
    }

    public static Student constructScoreAndCommentMaskedUser(Student student) {

        return Student.create(
                student.getId(),
                MASK,
                student.getName(),
                student.getEmail(),
                MASK,
                MASK
        );
    }
}
