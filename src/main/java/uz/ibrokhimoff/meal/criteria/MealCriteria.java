package uz.ibrokhimoff.meal.criteria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealCriteria extends GenericCriteria {

    @Schema(description = "yyyy-MM-dd", required = false)
    private String date;

}
