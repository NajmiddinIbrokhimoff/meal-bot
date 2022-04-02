package uz.ibrokhimoff.meal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.ibrokhimoff.meal.criteria.MealCriteria;
import uz.ibrokhimoff.meal.domain.Meal;
import uz.ibrokhimoff.meal.dto.meal.MealCreateDto;
import uz.ibrokhimoff.meal.dto.meal.MealDto;
import uz.ibrokhimoff.meal.dto.meal.MealUpdateDto;
import uz.ibrokhimoff.meal.dto.response.AppErrorDto;
import uz.ibrokhimoff.meal.dto.response.DataDto;
import uz.ibrokhimoff.meal.mappers.MealMapper;
import uz.ibrokhimoff.meal.repository.MealRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MealService implements AbstractService {
    private final MealRepository repository;
    private final MealMapper mapper;


    public ResponseEntity<DataDto<List<MealDto>>> getAll(MealCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Meal> meals = repository.findAllByDeletedFalse(request);
        return new ResponseEntity<>(new DataDto<>(mapper.toDto(meals), (long) meals.size()), HttpStatus.OK);
    }


    public ResponseEntity<DataDto<MealDto>> get(Long id) {
        Optional<Meal> mealOptional = repository.findByIdAndDeletedFalse(id);
        if (mealOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().build()), HttpStatus.OK);

        return new ResponseEntity<>(new DataDto<>(mapper.toDto(mealOptional.get())), HttpStatus.OK);
    }

    public ResponseEntity<DataDto<Boolean>> delete(Long id) {
        Optional<Meal> mealOptional = repository.findByIdAndDeletedFalse(id);
        if (mealOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto
                    .builder()
                    .status(HttpStatus.NOT_FOUND)
                    .build()), HttpStatus.OK);
        repository.delete(mealOptional.get());
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }


    public Long createFromTelegramBot(@NotNull MealCreateDto dto) {
        Meal meal = mapper.fromCreateDto(dto);
        repository.save(meal);
        return meal.getId();
    }

    public ResponseEntity<DataDto<Long>> create(MealCreateDto dto) {
        return null;
    }

    public ResponseEntity<DataDto<Boolean>> update(MealUpdateDto dto) {
        Optional<Meal> mealOptional = repository.findByIdAndDeletedFalse(dto.getId());
        if (mealOptional.isEmpty())
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("Meal not found by id : '%s".formatted(dto.getId()))
                    .build()), HttpStatus.OK);

        Meal meal = mapper.fromUpdateDto(dto, mealOptional.get());

        repository.save(meal);

        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }
}
