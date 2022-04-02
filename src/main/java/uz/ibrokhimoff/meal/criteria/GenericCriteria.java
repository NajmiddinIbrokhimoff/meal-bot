package uz.ibrokhimoff.meal.criteria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericCriteria {
    private Integer size;
    private Integer page;

    public Integer getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public Integer getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }
}
