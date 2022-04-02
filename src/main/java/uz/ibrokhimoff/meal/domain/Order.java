package uz.ibrokhimoff.meal.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long mealId;

    private Long userId;

    @Column(name = "received")
    private boolean received;

    @Column(name = "order_date")
    private LocalDate orderDate;

}