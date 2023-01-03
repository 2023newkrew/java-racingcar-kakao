package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cars {

    private static final int THRESHOLD = 4;
    private final List<Car> cars;
    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isMove(int number) {
        return number >= THRESHOLD;
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCarsWithSamePosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(ImmutableCar::new)
                .collect(Collectors.toList());
    }

    public void play() {
        cars.forEach(this::increasePositionIfMovable);
    }

    private void increasePositionIfMovable(Car car) {
        if(isMove(RandomNumberGenerator.generateRandomNumber())) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(ImmutableCar::new)
                .collect(Collectors.toList());
    }

}
