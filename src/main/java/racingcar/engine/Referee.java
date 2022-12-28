package racingcar.engine;

import java.util.ArrayList;
import java.util.List;
import racingcar.engine.model.Car;

public class Referee {

    public List<String> judgeWinner(List<Car> cars) {
        int max = 0;
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            max = car.renewWinners(max, result);
        }
        return result;
    }
}
