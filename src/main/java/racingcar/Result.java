package racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private final Map<String, Integer> positionMap;

    public Result(List<Car> position) {
        this.positionMap = position.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public int getPositionByName(String name) {
        return positionMap.get(name);
    }
}
