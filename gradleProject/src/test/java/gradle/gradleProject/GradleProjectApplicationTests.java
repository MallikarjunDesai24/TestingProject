package gradle.gradleProject;

import gradle.gradleProject.Repository.EmployeeRepository;

import gradle.gradleProject.model.Employee;
import gradle.gradleProject.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class GradleProjectApplicationTests {


	@Test
	void contextLoads(){

	}
//	@Autowired
//	private EmployeeService empService;
//
//	@MockBean
//	private EmployeeRepository empRepo;

//	@Test
//	void getUsersTest() {
//		when(empRepo.findAll().thenReturn(Stream.of(new Employee(1,"sonu",23)).collect(Collectors.toList())));
//		assertEquals(1,empService.getAllUsers().size());
//	}

}
