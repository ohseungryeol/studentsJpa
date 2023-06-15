package com.example.student.dto;

import com.example.student.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentDto { //사용자에게 보여질 Student데이터
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;

    //정적 팩토리 메서드 패턴
    public static StudentDto fromEntity(StudentEntity studentEntity){
        StudentDto dto = new StudentDto();
        dto.setId(studentEntity.getId());
        dto.setName(studentEntity.getName());
        dto.setAge(studentEntity.getAge());
        dto.setPhone(studentEntity.getPhone());
        dto.setEmail(studentEntity.getEmail());

        return dto;
    }
}
