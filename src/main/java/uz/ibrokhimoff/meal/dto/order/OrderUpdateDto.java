package uz.ibrokhimoff.meal.dto.order;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.ibrokhimoff.meal.dto.GenericDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class OrderUpdateDto extends GenericDto {
    private Long userId;
    private Long mealId;
    private LocalDate date;
    private boolean receive;

    @Builder(builderMethodName = "childBuilder")
    public OrderUpdateDto(@NotNull(message = "Id Can not be null") Long id, Long userId, Long mealId, LocalDate date, boolean receive) {
        super(id);
        this.userId = userId;
        this.mealId = mealId;
        this.date = date;
        this.receive = receive;
    }
}
