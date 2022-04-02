package uz.ibrokhimoff.meal.mappers;

import java.util.List;

public interface BaseMapper <E, D, CD, UD > {

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD d);
}
