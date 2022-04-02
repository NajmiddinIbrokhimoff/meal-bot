package uz.ibrokhimoff.meal.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.ibrokhimoff.meal.domain.Meal;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<Meal> findByIdAndDeletedFalse(@NotNull Long id);
    List<Meal> findAllByDeletedFalse(PageRequest request);

}
