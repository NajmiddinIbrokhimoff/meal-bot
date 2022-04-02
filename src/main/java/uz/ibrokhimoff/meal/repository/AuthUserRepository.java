package uz.ibrokhimoff.meal.repository;

import org.springframework.data.repository.CrudRepository;
import uz.ibrokhimoff.meal.domain.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends CrudRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsernameAndDeletedFalse(String name);

    Optional<AuthUser> findByChatIdAndDeletedFalse(String name);
}
