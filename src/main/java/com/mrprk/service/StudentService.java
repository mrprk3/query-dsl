package com.mrprk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrprk.entity.Student;
import com.mrprk.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public Student saveStddata(Student student) {
		return studentRepository.save(student);
	}

	public Optional<Student> getById(int id) {
		return studentRepository.findById(id);
	}

}
