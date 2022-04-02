package uz.ibrokhimoff.meal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ibrokhimoff.meal.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
