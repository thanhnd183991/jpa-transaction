package thanh.be.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.be.types.Employee;
import thanh.be.types.ThreadEntity;

public interface ThreadRepo extends JpaRepository<ThreadEntity, Integer> {
}
