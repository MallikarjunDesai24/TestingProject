package gradle.gradleProject.service;

import gradle.gradleProject.Repository.EmployeeRepository;

import gradle.gradleProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    //Get Mapping
    public List<Employee> getAllEmployees(){
        return empRepo.findAll();
    }

    //Get Mapping by Id
    public Employee getEmployeeById(Integer id){
        return empRepo.findById(id).orElse(null);
    }

    //Get Mapping StartsWith S
    public List<Employee> getEmployeesByNameStartsWithS(){
        return empRepo.nameStartsWithS();
    }

    //Get Mapping By Name
    public Employee getEmployeeByName(String name){
        return empRepo.getEmployeeByName(name);
    }

    public List<Employee> getEmployeesByAgeGreaterThan20(){
        List<Employee> employees=empRepo.findAll();
        List<Employee> employeesage20=new ArrayList<>();
        for(Employee employee: employees){
            if(employee.getAge()>=20){
                employeesage20.add(employee);
            }
        }
        return employeesage20;
    }

    //Put Mapping
    public Employee updateEmployee(Integer id,Employee employee){
        Employee existingEmployee=empRepo.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        return empRepo.save(existingEmployee);
    }

    //Post Mapping
    public Employee addEmployee(Employee employee){
        if(employee.getAge()==0||employee.getName()==null){
            throw new RuntimeException("give age or name value");
        }
        return empRepo.save(employee);
    }

    //Delete Mapping
    public void removeEmployee(Integer id){
         Employee employee= empRepo.findById(id).get();
         empRepo.delete(employee);

    }

    public String deleteEmployee(Integer id){
        empRepo.deleteById(id);
        return "Employee with id "+ id + " has been deleted";
    }
}
