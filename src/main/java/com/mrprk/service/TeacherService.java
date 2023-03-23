package com.mrprk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrprk.entity.Teacher;
import com.mrprk.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepository;

	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public Optional<Teacher> getByTeacherid(int id) {
		return teacherRepository.findById(id);
	}

}
