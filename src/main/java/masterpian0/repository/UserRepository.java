package masterpian0.repository;

import org.springframework.data.repository.CrudRepository;
import masterpian0.model.*;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    void deleteById(Long id);
}

