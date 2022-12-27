package racingcar.engine.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.engine.model.Car;

public class Referee {

//    public List<String> judgeWinner(List<Car> cars) {
//        int max = 0;
//        List<String> result = new ArrayList<>();
//        for (Car car : cars) {
//            max = car.temp(max, result);
//        }
//        return result;
//    }

    public List<String> judgeWinner(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter((car) -> car.getPosition() == max).map(Car::getName).collect(Collectors.toList());
    }
}
