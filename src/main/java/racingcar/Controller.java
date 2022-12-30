package racingcar;

import racingcar.domain.Racing;
import racingcar.view.View;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        List<String> names = View.inputCarNames();
        int roundNum = View.inputRoundNum();
        Racing racing = new Racing(names, roundNum);
        while (!racing.isEnd()) {
            racing.round();
            View.printRoundResult(racing.getRoundResult());
        }
        View.printWinner(racing.getWinner());
    }
}