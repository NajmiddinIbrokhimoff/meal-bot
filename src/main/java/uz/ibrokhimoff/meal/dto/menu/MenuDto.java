package uz.ibrokhimoff.meal.dto.menu;

import lombok.*;
import uz.ibrokhimoff.meal.dto.GenericDto;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto extends GenericDto {
    private Long mealId;
    private String date;

    @Builder(builderMethodName = "childBuilder")
    public MenuDto(@NotNull(message = "Id Can not be null") Long id, Long mealId, String date) {
        super(id);
        this.mealId = mealId;
        this.date = date;
    }
}
