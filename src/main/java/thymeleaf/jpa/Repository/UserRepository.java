package thymeleaf.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import thymeleaf.jpa.Model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNama(String nama);
}
