package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {
    private final StringParser stringParser;

    public CarCreator(StringParser stringParser) {
        this.stringParser = stringParser;
    }

    public Cars createCars(String playerNames) {
        List<Car> cars = new ArrayList<>();

        String[] parsedNames = stringParser.parse(playerNames);
        for (String name : parsedNames) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }
}
