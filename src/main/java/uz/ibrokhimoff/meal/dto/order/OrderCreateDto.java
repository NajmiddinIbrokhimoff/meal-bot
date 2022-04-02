package uz.ibrokhimoff.meal.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.ibrokhimoff.meal.dto.Dto;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class OrderCreateDto implements Dto {
    private Long mealId;
    private LocalDate date;
}
