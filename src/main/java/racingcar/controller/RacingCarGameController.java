package racingcar.controller;

import racingcar.domain.GameResult;
import racingcar.domain.RacingCarGame;
import racingcar.dto.CarInfo;
import racingcar.utils.RacingCarValidator;
import racingcar.view.GameView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameController {

    private final GameView gameView;
    private final RacingCarValidator racingCarValidator;

    public RacingCarGameController() {
        gameView = new GameView();
        racingCarValidator = new RacingCarValidator();
    }

    public void run() {
        String[] carNames = gameView.getCarNames().split(",");
        racingCarValidator.validateCarNames(carNames);

        List<CarInfo> carDtos = createCarList(carNames);
        int gameRound = gameView.getRound();

        gameView.printInitialResult(createInitialStatus(carDtos));
        execute(carDtos, gameRound);
    }

    public void execute(List<CarInfo> carDtos, int count) {
        RacingCarGame racingCarGame = new RacingCarGame(carDtos, count);

        while (!racingCarGame.isFinish()) {
            GameResult gameResult = racingCarGame.doNextRound();
            gameView.printResult(gameResult.getIntermediateResult());
        }

        gameView.printResult(racingCarGame.selectWinners().getFinalResult());
    }

    public String createInitialStatus(List<CarInfo> carDtos) {
        return new GameResult(carDtos).getIntermediateResult();
    }

    public List<CarInfo> createCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new CarInfo(carName, 1))
                .collect(Collectors.toList());
    }

}