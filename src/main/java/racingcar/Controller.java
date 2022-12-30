package racingcar;

import racingcar.domain.Racing;
import racingcar.dto.InputDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputDto inputDto = inputView.creatInput();

        List<String> carNames = inputDto.getCarNames();
        int roundNum = inputDto.getRoundNum();

        Racing racing = new Racing(carNames, roundNum);
        while (!racing.isEnd()) {
            racing.round();
            OutputView.printRoundResult(racing.getRoundResult());
        }
        OutputView.printWinner(racing.getWinner());
    }
}