package gradle.gradleProject.service;

import gradle.gradleProject.Repository.EmployeeRepository;
import gradle.gradleProject.model.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    public EmployeeServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "sonu", 23),
                new Employee(2, "sidhu", 33),
                new Employee(3, "deepak", 21)
        );
//        when(employeeRepository.findAll()).thenReturn(employees);
        employeeRepository.saveAll(employees);
        assertEquals(3,employeeRepository.findAll().size());
//        assertEquals(employees, employeeService.getAllEmployees());
    }

//    @Test
//    void testGetAllUsers() {
//        List<Employee> employees= Arrays.asList(
//                new Employee(1,"sonu",23),
//                new Employee(2,"sidhu",33),
//                new Employee(3,"deepak",21)
//        );
//
//        EmployeeRepository employeeRepository= mock(EmployeeRepository.class);
//
//        EmployeeService employeeService=new EmployeeService(employeeRepository);
//
//        when(employeeRepository.findAll()).thenReturn(employees);
//        assertEquals(employees, employeeService.getAllUsers());
//    }

    @Test
    void testGetEmployeeById() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "sonu", 23),
                new Employee(2, "sidhu", 33),
                new Employee(3, "deepak", 21)
        );
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employees.get(0)));
        assertEquals("sonu", employeeService.getEmployeeById(1).getName());
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(1, "sonu", 23);
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.addEmployee(employee);
        assertEquals("sonu", result.getName());
        assertEquals(23, result.getAge());
    }

//    @Test
//    void testUpdateEmployee() {
//        Employee employee = new Employee(2, "sidhu", 33);
//        Employee updateEmployee = employee;
//        updateEmployee.setName(employee.getName());
//        updateEmployee.setAge(employee.getAge());
//
//    }

    @Test
    void testDeleteEmployee() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "sonu", 23),
                new Employee(2, "sidhu", 33),
                new Employee(3, "deepak", 21)
        );

        employeeRepository.saveAll(employees);
        assertEquals(2,employeeRepository.findAll().size());

        employeeRepository.deleteById(1);

        employees = employeeRepository.findAll();

        Optional<Employee> employee1 = employees.stream().filter(employee -> (employee.getId() == 1)).findFirst();

        assertTrue(!employee1.isPresent());

//




    }
//    @Test
//    void testDeleteEmployee() {
//        // Create a sample employee
//        Employee employee = new Employee(1, "John", 30);
//
//        // Mock the behavior of the repository
//        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
//
//        // Call the service method to delete the employee
//        employeeService.removeUser(employee.getId());
//
//        // Verify that the employee has been deleted
//        assertFalse(employeeRepository.findById(employee.getId()).isPresent(), "Employee should be deleted");
//    }

//    @Test
//    void testRemoveEmployee(){
//        List<Employee> employees = Arrays.asList(
//                new Employee(1, "sonu", 23),
//                new Employee(2, "sidhu", 33),
//                new Employee(3, "deepak", 21)
//        );
//
//    // Mock the behavior of empRepo to return the first employee when findById method is called with ID 1
//    when(employeeRepository.findById(1)).thenReturn(Optional.of(employees.get(0)));
//    when(employeeRepository.delete(employees.get(0)).thenReturn(employees.get(0));
//    employeeService.removeUser(1);
//    verify(employeeRepository)






    @Test
    void testNameStartsWithS() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "sonu", 23),
                new Employee(2, "sidhu", 33)
        );
        when(employeeRepository.nameStartsWithS()).thenReturn(employees);

        assertEquals(employees, employeeService.getEmployeesByNameStartsWithS());
    }

    @Test
    void testGetEmployeeByName() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "sonu", 23),
                new Employee(2, "sidhu", 33),
                new Employee(3, "deepak", 21)
        );
        when(employeeRepository.getEmployeeByName("sonu")).thenReturn(employees.get(0));
        assertEquals(employees.get(0).getAge(), employeeService.getEmployeeByName("sonu").getAge());
    }

    @Test
    void testGetEmployeeByAgeGreaterThan20() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "sonu", 23),
                new Employee(2, "sidhu", 13),
                new Employee(3, "deepak", 21),
                new Employee(4, "likhi", 17)
        );

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getEmployeesByAgeGreaterThan20();



        // Verify that the correct number of employees with age greater than or equal to 20 are returned
        assertEquals(2, result.size());

        // Verify that the returned list contains only employees with age greater than or equal to 20
        for (Employee employee : result) {
            assertTrue(employee.getAge() >= 20);
        }
    }
//    @Test
//    void testDeleteUserById(){
//        List<Employee> employees= Arrays.asList(
//                new Employee(1,"sonu",23),
//                new Employee(2,"sidhu",33),
//                new Employee(3,"deepak",21)
//        );
//        int id=employees.get(1).getId();
//
//        when(employeeRepository).deleteById(id);
//
//
//        assertEquals(2,employees.size());
//    }



}