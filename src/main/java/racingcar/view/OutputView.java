package racingcar.view;

import racingcar.Constant.StringConstant;
import racingcar.model.Car;

import java.util.List;

/**
 * 프로그램의 UI로직을 담당하는 클래스입니다.
 * 컨트롤러에게 받은 데이터를 바탕으로 output string을 구성하고 프린트합니다.
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
