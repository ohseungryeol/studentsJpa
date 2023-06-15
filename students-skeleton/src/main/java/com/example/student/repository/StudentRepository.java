package com.example.student.repository;

import com.example.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//데이터베이스와 소통하는 레포지토리 클래스
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> { // <Entitiy 클래스, pk타입>

}
