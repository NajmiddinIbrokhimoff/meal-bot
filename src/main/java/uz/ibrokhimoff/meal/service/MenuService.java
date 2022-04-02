package uz.ibrokhimoff.meal.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.ibrokhimoff.meal.domain.Menu;
import uz.ibrokhimoff.meal.dto.menu.MenuCreateDto;
import uz.ibrokhimoff.meal.dto.menu.MenuDto;
import uz.ibrokhimoff.meal.dto.menu.MenuUpdateDto;
import uz.ibrokhimoff.meal.dto.response.AppErrorDto;
import uz.ibrokhimoff.meal.dto.response.DataDto;
import uz.ibrokhimoff.meal.mappers.MenuMapper;
import uz.ibrokhimoff.meal.repository.MenuRepository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService implements AbstractService {
    private final MenuRepository repository;
    private final MenuMapper mapper;


    public ResponseEntity<DataDto<List<MenuDto>>> getAllByDate(String date) {
        LocalDate dateFor = LocalDate.parse(date);
        List<Menu> menus = repository.findAllByDeletedFalseAndMenuDate(dateFor);
        return new ResponseEntity<>(new DataDto<>(mapper.toDto(menus), (long) menus.size()), HttpStatus.OK);
    }


    public ResponseEntity<DataDto<MenuDto>> get(Long id) {
        Optional<Menu> mealOptional = repository.findByIdAndDeletedFalse(id);
        if (mealOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().build()), HttpStatus.OK);

        return new ResponseEntity<>(new DataDto<>(mapper.toDto(mealOptional.get())), HttpStatus.OK);
    }

    public ResponseEntity<DataDto<Boolean>> delete(Long id) {
        Optional<Menu> mealOptional = repository.findByIdAndDeletedFalse(id);
        if (mealOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto
                    .builder()
                    .status(HttpStatus.NOT_FOUND)
                    .build()), HttpStatus.OK);
        repository.delete(mealOptional.get());
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }


    public Long createFromTelegramBot(@NotNull MenuCreateDto dto) {
        Menu meal = mapper.fromCreateDto(dto);
        repository.save(meal);
        return meal.getId();
    }

    public ResponseEntity<DataDto<Long>> create(MenuCreateDto dto) {
        return null;
    }

    public ResponseEntity<DataDto<Boolean>> update(MenuUpdateDto dto) {
        Optional<Menu> mealOptional = repository.findByIdAndDeletedFalse(dto.getId());
        if (mealOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("Menu not found by id : '%s".formatted(dto.getId()))
                    .build()), HttpStatus.OK);

        Menu meal = mapper.fromUpdateDto(dto, mealOptional.get());

        repository.save(meal);

        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }


}