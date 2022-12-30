package racingcar;

import racingcar.domain.Racing;
import racingcar.dto.InputDto;
import racingcar.dto.RoundResultDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private static Racing settings() {
        InputDto inputDto = InputView.creatInput();

        List<String> carNames = inputDto.getCarNames();
        int roundNum = inputDto.getRoundNum();

        return new Racing(carNames, roundNum);
    }

    private static void printRoundResult(Racing racing) {
        RoundResultDto roundResultDto = racing.calculateRoundResult();
        OutputView.printRoundResult(roundResultDto.getCarState());
    }

    private static void printWinnerResult(Racing racing) {
        OutputView.printWinner(racing.calculateWinner().getWinners());
    }

    public static void main(String[] args) {
        Racing racing = settings();

        while (!racing.isEnd()) {
            racing.round();
            printRoundResult(racing);
        }
        printWinnerResult(racing);
    }
}