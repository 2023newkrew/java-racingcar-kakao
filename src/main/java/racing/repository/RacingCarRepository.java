package racing.repository;

import racing.exception.ErrorCode;
import racing.exception.RacingException;
import racing.model.Car;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarRepository {
    private static final Integer CARNAME_MAX_LENGTH = 5;

    private final List<Car> cars;

    public RacingCarRepository(List<Car> cars){
        validateCarName(cars);
        this.cars = cars;
    }

    private void validateCarName(List<Car> cars){
        cars.forEach(car -> {
            if(car.getName().isBlank()) throw new RacingException(ErrorCode.EMPTY_CAR_NAME);
            if(car.getName().length() > CARNAME_MAX_LENGTH) throw new RacingException(ErrorCode.TOO_LONG_CAR_NAME);
        });

    }

    public List<Car> getCars(){
        return cars;
    }

    public List<String> getWinners() {
        Integer max = Collections.max(cars).getPosition();
        return cars.stream()
                .filter(car -> Objects.equals(car.getPosition(), max))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
