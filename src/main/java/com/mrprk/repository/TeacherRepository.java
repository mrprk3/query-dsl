package com.mrprk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrprk.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
