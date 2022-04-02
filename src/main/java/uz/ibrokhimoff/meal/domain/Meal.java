package uz.ibrokhimoff.meal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "meal", indexes = {
        @Index(name = "meal_name_key", columnList = "name", unique = true)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "file_id",nullable = false)
    private String fileId;

    @Column(name = "is_deleted", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

}