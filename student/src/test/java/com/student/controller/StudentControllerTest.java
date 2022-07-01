package com.student.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.student.bean.Address;
import com.student.bean.Fees;
import com.student.bean.PersonalDetail;
import com.student.bean.Student;
import com.student.service.Service;
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = StudentController.class)
class StudentControllerTest {
	
	@Autowired
	StudentController controller;
	
	@MockBean
	Service service;
	@Test
	void addRecordTest() {
		Student student = new Student();
		student.setName(student.getName());
		student.setSClass(student.getSClass());
		student.setId(student.getId());
		PersonalDetail personalDetail = new PersonalDetail();
		student.setDetail(personalDetail);
		Address address = new Address();
		address.setCity(address.getCity());
		address.setCountry(address.getCountry());
		address.setId(address.getId());
		address.setState(address.getState());
		personalDetail.setId(personalDetail.getId());
		personalDetail.setAddress(address);
		Fees fees = new Fees();
		personalDetail.setFees(fees);
		fees.setId(fees.getId());
		fees.setAmmount(fees.getAmmount());
		fees.setBankDetails(fees.getBankDetails());
		fees.setHolderName(fees.getHolderName());
		Mockito.when(service.addRecord(student)).thenReturn(student);
		Student addRecord = controller.addRecord(student);
		assertThat(addRecord);
	}

	@Test
	void getByIdTest() {
		Optional<Student> opt = Optional.empty();
		Mockito.when(service.getById(6)).thenReturn(opt);
		Optional<Student> byId = controller.getById(6);
		assertThat(byId);
	}
	
	@Test
	void getAllTest() {
		Student student = new Student();
		List<Student> list = new ArrayList<Student>();
		Mockito.when(service.getAll()).thenReturn(list);
		List<Student> all = controller.getAll();
		assertThat(all);
	}
	
	@Test
	void updateByIdTest() {
		Student student = new Student();
		Mockito.when(service.updateById(student)).thenReturn(student);
		Student updateById = controller.updateById(student);
		assertThat(updateById);
	}
	
	@Test
	void deletedByIdTest() {
		Student student = new Student();
		Mockito.when(service.deletedById(3)).thenReturn("delete Data");
		String deletedById = controller.deletedById(3);
		assertThat(deletedById);
	}
	
//	@Test
//	void getDataTest() {
//		String getData = controller.getData();
//		assertThat(getData);
//	}

}
