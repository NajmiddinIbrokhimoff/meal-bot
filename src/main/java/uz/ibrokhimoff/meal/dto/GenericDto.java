package uz.ibrokhimoff.meal.dto;

import uz.ibrokhimoff.meal.domain.base.Auditable;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericDto implements Dto{

    @NotNull(message = "Id Can not be null")
    private Long id;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Auditable other = (Auditable) obj;
        return Objects.equals(id,other.getId());
    }
}
