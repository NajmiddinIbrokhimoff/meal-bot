package uz.ibrokhimoff.meal.dto.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.ibrokhimoff.meal.dto.GenericDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuUpdateDto extends GenericDto {
    private String date;
    private Long mealId;
}
