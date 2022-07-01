package com.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentApplicationTests {

	@Test
	@DisplayName("Spring boot application main method testing")
	void main() {
		StudentApplication.main(new String[] {});
	}

}
