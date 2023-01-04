package racingcar.step2.view;

import racingcar.step2.domain.Car;
import racingcar.step2.domain.Cars;

import java.util.List;

public class ResultView {

    private static final String MSG_FINAL_RESULT_FORMAT = "%s(이)가 최종 우승했습니다.\n";
    private static final String WINNERS_DELIMITER = ", ";

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
