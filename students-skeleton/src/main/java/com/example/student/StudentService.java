package com.example.student;

import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    //서비스는 레포지토리에게 데이터 요청
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) { //생성자를 통한 레포지토리 의존성 주입(DI)
        this.repository = repository;
    }

    // CREATE
    public void createStudent() {}

    // READ
    public void readStudent() {}

    // READ ALL
    public void readStudentAll() {}

    // UPDATE
    public void updateStudent() {}

    // DELETE
    public void deleteStudent() {}
}
