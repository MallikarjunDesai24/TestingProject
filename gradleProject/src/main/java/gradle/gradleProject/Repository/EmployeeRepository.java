package gradle.gradleProject.Repository;

import gradle.gradleProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value="select * from employee where name like 's%'", nativeQuery = true)
    List<Employee> nameStartsWithS();

    @Query(value="select * from employee where name=:name", nativeQuery=true)
    Employee getEmployeeByName(String name);
}
