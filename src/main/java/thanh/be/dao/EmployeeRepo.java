package thanh.be.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.be.types.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
