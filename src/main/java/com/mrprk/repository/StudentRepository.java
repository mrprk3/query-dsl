package com.mrprk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrprk.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByIdOrNameOrPhone(int id, String name, String phone);


 
}
