package com.example.student.entity;
/* CREATE TABLE students (
*   id INTEGER PRIMARY KEY AUTOINCREMENT,
*   name TEXT,
*   age INTEGER,
*   phone TEXT,
*   email TEXT
* */

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity //클래스를 테이블로  정의
@Table(name = "students") //테이블 이름
public class StudentEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk값 자동증가, 생성
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
}

