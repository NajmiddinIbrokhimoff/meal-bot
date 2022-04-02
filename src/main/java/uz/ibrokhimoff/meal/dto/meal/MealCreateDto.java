package uz.ibrokhimoff.meal.dto.meal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import uz.ibrokhimoff.meal.dto.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MealCreateDto implements Dto {

    @Schema(hidden = false, required = true)
    @NotBlank(message = "Meal name cannot be null or blank")
    private String name;

    @Schema(required = true)
    @NotNull(message = "Meal picture cannot be null")
    private String picture;
}
