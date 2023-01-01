package racingcar.view;

import racingcar.Constant.StringConstant;
import racingcar.model.Car;

import java.util.List;

/**
 * 프로그램의 UI로직을 담당하는 클래스입니다.
 * 사용자 input도 여기에서 담당합니다.
 */
public class OutputView {

    public void printGameResult(String gameLog) {
        System.out.print(gameLog);
    }

    public void printWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            stringBuilder.append(winner.getName() + StringConstant.COMMA + StringConstant.SPACE);
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }
}
