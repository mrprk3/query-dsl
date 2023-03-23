package com.mrprk.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mrprk.dao.StudentDao;
import com.mrprk.entity.QStudent;
import com.mrprk.entity.QTeacher;
import com.mrprk.entity.Student;
import com.mrprk.repository.StudentRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	StudentRepository studentRepository;

	@Override
	public List<Student> searchByAnyCriteria(Student student) {
		int teacherid = 111;

		JPAQuery<Tuple> query = new JPAQuery<Tuple>(entityManager);
		List<Tuple> res = query.from(QStudent.student, QTeacher.teacher).select(QStudent.student, QTeacher.teacher)
				.where(isStudentId(student.getId()), isTeacherId(teacherid)).fetch();
		System.out.println("=======================================" + res);

		
		return null;
	}

	private Predicate isTeacherId(int teacherid) {
		return (teacherid == 0 ? null : QTeacher.teacher.teacherid.eq(teacherid));
	}

	private Predicate isStudentId(int id) {
		return (id == 0 ? null : QStudent.student.id.eq(id));
	}

}
