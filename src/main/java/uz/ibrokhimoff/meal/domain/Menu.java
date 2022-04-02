package uz.ibrokhimoff.meal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "menu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long mealId;

    @Column(name = "menu_date")
    private LocalDate menuDate;

    @Column(name = "is_deleted", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

}