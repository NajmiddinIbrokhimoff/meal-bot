package uz.ibrokhimoff.meal.mappers;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.ibrokhimoff.meal.domain.Order;
import uz.ibrokhimoff.meal.dto.order.OrderCreateDto;
import uz.ibrokhimoff.meal.dto.order.OrderDto;
import uz.ibrokhimoff.meal.dto.order.OrderUpdateDto;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<
        Order,
        OrderDto,
        OrderCreateDto,
        OrderUpdateDto> {
    @Override
    OrderDto toDto(Order order);

    @Override
    List<OrderDto> toDto(List<Order> e);

    @Override
    Order fromCreateDto(OrderCreateDto orderCreateDto);

    @Override
    Order fromUpdateDto(OrderUpdateDto d);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order fromUpdateDto(OrderUpdateDto dto,@MappingTarget Order order);
}
