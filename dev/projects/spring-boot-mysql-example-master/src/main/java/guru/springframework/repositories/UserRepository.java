package guru.springframework.repositories;

import guru.springframework.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
