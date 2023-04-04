package thanh.be.controller.services;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thanh.be.dao.EmployeeRepo;
import thanh.be.types.Employee;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Transactional(
           
    )
    public void test() {
        Employee employee = employeeRepo.findById(1).orElse(null);
        if (employee != null) {
            employee.setEmail(RandomString.make(10));
        }

    }
}
