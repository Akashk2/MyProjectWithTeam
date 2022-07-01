package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.bean.Student;
import com.student.dao.StudentDao;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private StudentDao studentDao;

	public Student addRecord(Student student) {
		return studentDao.save(student);
	}
	
	
	public Optional<Student> getById(int id) {
		return studentDao.findById(id);
	}
	
	
	public List<Student> getAll() {
		return studentDao.findAll();
	}
	
	
	public Student updateById(Student student) {
		return studentDao.save(student);
	}
	
	public String deletedById(int id) {
		studentDao.deleteById(id);
		return "deleted data";
	}
}
