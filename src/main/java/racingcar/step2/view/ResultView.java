package racingcar.step2.view;

import racingcar.step2.domain.Car;
import racingcar.step2.domain.Cars;

import java.util.List;

import static racingcar.step2.util.MessageConstants.MSG_FINAL_RESULT_FORMAT;
import static racingcar.step2.util.RacingCarConstants.WINNERS_DELIMITER;

public class ResultView {

    public void printTurnResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void printGameResult(List<String> winners) {
        System.out.printf(MSG_FINAL_RESULT_FORMAT, String.join(WINNERS_DELIMITER, winners));
    }
}
