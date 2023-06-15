package com.example.student;

import com.example.student.dto.StudentDto;
import com.example.student.entity.StudentEntity;
import com.example.student.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    //서비스는 레포지토리에게 데이터 요청
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) { //생성자를 통한 레포지토리 의존성 주입(DI)
        this.repository = repository;
    }

    // CREATE
    public StudentDto createStudent(StudentDto studentDto) {
        StudentEntity newStudent = new StudentEntity();
        newStudent.setName(studentDto.getName());
        newStudent.setAge(studentDto.getAge());
        newStudent.setId(studentDto.getId());
        newStudent.setPhone(studentDto.getPhone());
        newStudent.setEmail(studentDto.getEmail());

        return StudentDto.fromEntity(repository.save(newStudent));
    }

    // READ
    public StudentDto readStudent(Long id) {
        Optional<StudentEntity> optinalEntity = repository.findById(id);
        if(optinalEntity.isPresent()){
            return StudentDto.fromEntity(optinalEntity.get());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    // READ ALL
    public List<StudentDto> readStudentAll() { //모든 studentDto 리스트 리턴
        List<StudentEntity> allStudent = this.repository.findAll();
        List<StudentDto> allStudentDto = new ArrayList<>();

        for(StudentEntity studentEntity:allStudent){
            StudentDto dto = StudentDto.fromEntity(studentEntity);
            allStudentDto.add(dto);
        }

        return allStudentDto;
    }

    // UPDATE
    public StudentDto updateStudent(Long id, StudentDto dto) {
        Optional<StudentEntity> optionalEntity = repository.findById(id);

        if(optionalEntity.isPresent()){
            StudentEntity targetEntity = optionalEntity.get();
            targetEntity.setEmail(dto.getEmail());
            targetEntity.setName(dto.getName());
            targetEntity.setAge(dto.getAge());
            targetEntity.setPhone(dto.getPhone());
            targetEntity.setId(dto.getId());
            //repository.save(targetEntity);
            return StudentDto.fromEntity(repository.save(targetEntity));
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
