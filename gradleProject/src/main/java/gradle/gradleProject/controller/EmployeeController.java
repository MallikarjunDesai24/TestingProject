package gradle.gradleProject.controller;

import gradle.gradleProject.Repository.EmployeeRepository;
import gradle.gradleProject.model.Employee;
import gradle.gradleProject.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empinfo")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private EmployeeService empService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllUsers(){
        return empService.getAllEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getUserById(@PathVariable Integer id){
        return empService.getEmployeeById(id);
    }

    @GetMapping("/getEmployeeByNameStartsWithS")
    public List<Employee> getEmployeeByNameStartsWithS(){
        return empService.getEmployeesByNameStartsWithS();
    }

    @GetMapping("/getEmployeeByName")
    public Employee getEmployeeByName(@RequestParam String name){
        return empService.getEmployeeByName(name);
    }

    @GetMapping("/getEmployeesByAgeGreaterThan20")
    public List<Employee> getEmployeesByAgeGreaterThan20(){
        return empService.getEmployeesByAgeGreaterThan20();
    }
    @PutMapping("/updateEmployee/{id}")
    public Employee updateUser(@PathVariable Integer id,@RequestBody Employee employee){
        return empService.updateEmployee(id, employee);
    }
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return empService.addEmployee(employee);
    }

    @DeleteMapping("/removeEmployeeById/{id}")
    public void removeEmployeeById(@PathVariable Integer id){
        empService.removeEmployee(id);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable Integer id){
        return empService.deleteEmployee(id);

    }
}
