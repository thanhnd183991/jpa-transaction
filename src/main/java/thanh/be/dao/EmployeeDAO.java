package thanh.be.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import thanh.be.redis.CacheService;
import thanh.be.types.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class EmployeeDAO {
    private final CacheService cacheService;
    private static final String EMPLOYEE_KEY = "employee";

    public void addEmployee(Employee e) {
        List<Employee> rs = null;
        rs = new ArrayList<>();
        rs.add(e);

        cacheService.setList(EMPLOYEE_KEY, rs);
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) cacheService.get(EMPLOYEE_KEY);
    }

    public void deleteEmployees() {
        cacheService.delete(EMPLOYEE_KEY);


    }


}
