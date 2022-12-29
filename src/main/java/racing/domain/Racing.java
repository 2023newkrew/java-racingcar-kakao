package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    public String[] splitName(String names) {
        return names.split(",");
    }

    public Car[] makeCarList(String[] names) {
        return Arrays.stream(names)
                .map(name -> new Car(name))
                .toArray(Car[]::new);
    }

    public Car[] createCars(String names) {
        return makeCarList(splitName(names));
    }

    public Car[] oneCycle(Car[] cars) {
        Arrays.stream(cars).forEach(s -> s.carEvent());
        return cars;
    }

}
