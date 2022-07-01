package com.student.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.student.StudentApplication;
import com.student.bean.Student;
import com.student.dao.StudentDao;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentApplication.class)
@Transactional
class ServiceTest {

	@Mock
	StudentDao dao;
	@InjectMocks
	Service service;
	
	@Test
	void addRecordTest() {
		Student student = new Student();
		Mockito.when(dao.save(student)).thenReturn(student);
		Student addRecord = service.addRecord(student);
		assertThat(addRecord);
	}

	@Test
	void getByIdTest() {
		Optional<Student> opt = Optional.empty();
		Mockito.when(dao.findById(3)).thenReturn(opt);
		Optional<Student> byId = service.getById(3);
		assertThat(byId);
	}
	
	@Test
	void getAllTest() {
		List<Student> opt = new ArrayList<Student>();
		Mockito.when(dao.findAll()).thenReturn(opt);
		List<Student> all = service.getAll();
		assertThat(all);
	}
	
	@Test
	void updateByIdTest() {
		Student student = new Student();
		Mockito.when(dao.save(student)).thenReturn(student);
		Student addRecord = service.updateById(student);
		assertThat(addRecord);
	}
	
	@Test
	void deletedByIdTest() {
		Optional<Student> opt = Optional.empty();
		String deletedById = service.deletedById(3);
		assertThat(deletedById);
	}
}
