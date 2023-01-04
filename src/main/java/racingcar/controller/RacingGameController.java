package racingcar.controller;

import racingcar.Constant.StringConstant;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

/**
 * Racing Game을 실제로 구동시키는 클래스입니다.
 * RacingGame 모델과 OutputView 뷰를 사용하여 구동됩니다.
 */
public class RacingGameController {

    OutputView outputView;
    Scanner sc;

    public RacingGameController() {
        outputView = new OutputView();
        sc = new Scanner(System.in);
    }

    public void start() {
        List<String> carNamesInput = carNamesUserInput();

        int trialNumber = trialNumberUserInput();

        RacingGame racingGame = new RacingGame(trialNumber, carNamesInput);

        racingGame.runRacingGame();
        outputView.printGameResult(racingGame.gameLog());

        outputView.printWinners(racingGame.winners());
    }

    public List<String> carNamesUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();

        List<String> carNameList = SplitCarNames(carNames);

        return carNameList;
    }

    private List<String> SplitCarNames(String carNames) {
        return List.of(carNames.split(StringConstant.COMMA));
    }

    public int trialNumberUserInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int trialNumber = Integer.parseInt(sc.next());

        return trialNumber;
    }
}
