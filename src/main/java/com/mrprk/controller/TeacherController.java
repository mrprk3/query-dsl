package com.mrprk.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrprk.entity.Teacher;
import com.mrprk.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;

	@PostMapping("/save")
	public ResponseEntity<Teacher> saveTeacherDetails(@RequestBody Teacher teacher) {
		Teacher res = teacherService.saveTeacher(teacher);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Teacher>> getTeacherData(@PathVariable int id) {
		Optional<Teacher> res = teacherService.getByTeacherid(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
