package racing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class Cars {

    private List<Car> cars;

    private static final int THRESHOLD = 4;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isMove(int number) {
        return number >= THRESHOLD;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public int getMaxPosition() {
        int maxPosition = -1;
        for (Car car: cars) {
            maxPosition = max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCarsWithSamePosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
