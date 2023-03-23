package com.mrprk.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mrprk.dao.TeacherDao;
import com.mrprk.entity.QStudent;
import com.mrprk.entity.QTeacher;
import com.mrprk.entity.Teacher;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class TeacherIDaoImpl implements TeacherDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Teacher> searchTeacherByAnyCriteria(Teacher teacher) {
		JPAQuery<Tuple> query = new JPAQuery<>(entityManager);
		return query.from(QTeacher.teacher).select(QTeacher.teacher).where(isTeacherId(teacher.getTeacherid())).fetch();
	}

	private Predicate isTeacherId(int teacherid) {
		return (teacherid == 0 ? null : QTeacher.teacher.teacherid.eq(teacherid));
	}

}
