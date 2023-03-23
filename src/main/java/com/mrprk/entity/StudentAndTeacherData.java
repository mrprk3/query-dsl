package com.mrprk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAndTeacherData {
	
	private int id;
	
	private String name;
	
	private String phone;
	
	private int teacherid;

	private String teachername;

	private String teachersubject;

}
