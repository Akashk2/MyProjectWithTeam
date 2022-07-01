package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.bean.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}
