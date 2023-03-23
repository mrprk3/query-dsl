package com.mrprk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrprk.dao.StudentDao;
import com.mrprk.entity.Student;
import com.mrprk.repository.StudentRepository;
import com.mrprk.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@Autowired
	StudentRepository repo;

	@Autowired
	StudentDao studentDao;

	@PostMapping("/save")
	public ResponseEntity<Student> saveStudentData(@RequestBody Student student) {
		Student res = studentService.saveStddata(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable int id) {
		Optional<Student> res = studentService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	// Search data by any criteria using query dsl
	@PostMapping("/search/criteria")
	public ResponseEntity<List<Student>> searchCriteria(@RequestBody Student student) {
		List<Student> res = studentDao.searchByAnyCriteria(student);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	// Another way to write search data by any criteria
	@PostMapping("/get")
	public Student getStudent(@RequestBody Student student) {
		int id = student.getId();
		String name = student.getName();
		String phone = student.getPhone();
		return repo.findByIdOrNameOrPhone(id, name, phone);
	}

}
