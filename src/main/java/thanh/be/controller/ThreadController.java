package thanh.be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanh.be.dao.EmployeeRepo;
import thanh.be.dao.ThreadRepo;
import thanh.be.types.Employee;
import thanh.be.types.ThreadEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/threads")
public class ThreadController {
    //    private final EmployeeDAO employeeDAO;
    private final ThreadRepo threadRepo;

    @PostMapping
    public ResponseEntity<String> createThread(@RequestBody ThreadEntity thread) {
        threadRepo.save(thread);
        return ResponseEntity.ok().body("create new thread");
    }

    @GetMapping
    public ResponseEntity<List<ThreadEntity>> list() {
        List<ThreadEntity> threads = threadRepo.findAll();
        return ResponseEntity.ok().body(threads);
    }

}
