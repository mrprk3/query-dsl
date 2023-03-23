package com.mrprk.dao;

import java.util.List;

import com.mrprk.entity.Teacher;

public interface TeacherDao {

	public List<Teacher> searchTeacherByAnyCriteria(Teacher teacher);

}
