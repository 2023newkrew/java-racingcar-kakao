package racing.model;

import racing.exception.ErrorCode;
import racing.exception.RacingException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final Integer CARNAME_MAX_LENGTH = 5;

    private final List<Car> cars;

    public Cars(){
        cars = new ArrayList<>();
    }

    public void tryMoveAll(){
        for (Car car : cars) {
            car.tryMove();
        }
    }

    public void addCars(List<Car> cars){
        validateCarName(cars);
        this.cars.addAll(cars);
    }

    private void validateCarName(List<Car> cars){
        cars.forEach(car -> {
            if(car.getName().isBlank()){
                throw new RacingException(ErrorCode.EMPTY_CAR_NAME);
            }
            if(car.getName().length() > CARNAME_MAX_LENGTH){
                throw new RacingException(ErrorCode.TOO_LONG_CAR_NAME);
            }
        });

    }

    public List<String> getWinnerCarName(){
        return cars.stream()
                .filter(car -> Objects.equals(car.getPosition(), findMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Integer findMaxPosition(){
        return Collections.max(cars).getPosition();
    }

    public List<String> getAllCarStatusStrings(){
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public void deleteAllCars(){
        cars.clear();
    }
}
