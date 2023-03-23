package com.mrprk.dao;

import java.util.List;

import com.mrprk.entity.Student;

public interface StudentDao {

	public List<Student> searchByAnyCriteria(Student student);

}
