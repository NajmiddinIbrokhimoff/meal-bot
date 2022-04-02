package uz.ibrokhimoff.meal.dto.meal;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.ibrokhimoff.meal.dto.GenericDto;

@Getter
@Setter
@NoArgsConstructor
public class MealUpdateDto extends GenericDto {
    private String name;
    private String image;

    @Builder(builderMethodName = "childBuilder")
    public MealUpdateDto(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
