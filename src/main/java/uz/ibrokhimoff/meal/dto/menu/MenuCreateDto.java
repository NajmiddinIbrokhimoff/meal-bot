package uz.ibrokhimoff.meal.dto.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.ibrokhimoff.meal.dto.Dto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateDto implements Dto {
    private String date;
    private Long mealId;
}
