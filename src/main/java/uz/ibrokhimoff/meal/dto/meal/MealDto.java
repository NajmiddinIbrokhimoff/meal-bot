package uz.ibrokhimoff.meal.dto.meal;

import uz.ibrokhimoff.meal.dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MealDto extends GenericDto {
    private String name;
    private String image;


    @Builder(builderMethodName = "childBuilder")
    public MealDto(Long id, String name, String image) {
        super(id);
        this.name = name;
        this.image = image;
    }
}
