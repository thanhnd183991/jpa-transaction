package thanh.be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanh.be.dao.EmployeeDAO;
import thanh.be.dao.EmployeeRepo;
import thanh.be.threads.RunnableImpl;
import thanh.be.types.Employee;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    //    private final EmployeeDAO employeeDAO;
    private final EmployeeRepo employeeRepo;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                employeeRepo.save(employee);
            }
        });
       
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                employeeRepo.save(employee);
            }
        });

        return ResponseEntity.ok().body("create new employee");
    }

    @GetMapping
    public ResponseEntity<List<Employee>> list() {
        List<Employee> employees = employeeRepo.findAll();
        return ResponseEntity.ok().body(employees);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployees() {
//        employeeDAO.deleteEmployees();
        return ResponseEntity.ok().body("deleted");
    }
}
