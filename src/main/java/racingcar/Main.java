package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = View.inputCarNames();
        int roundNum = View.inputRoundNum();
        Racing racing = new Racing(names, roundNum);
        for(int i = 0; i<roundNum; i++) {
            racing.round();
            View.printRoundResult(racing.roundResult());
        }
        View.printWinner(racing.getWinner());
    }
}
