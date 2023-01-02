package racingcar.controller;

import racingcar.domain.RandomNumberMovable;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.config.GameSetting;
import racingcar.controller.dto.CarRequest;
import racingcar.service.RacingCarGame;
import racingcar.utils.RacingCarConverter;
import racingcar.utils.RacingCarValidator;

import java.util.List;

public class RacingCarGameController {

    private InputView inputView;
    private OutputView outputView;
    private RacingCarValidator racingCarValidator;

    public RacingCarGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingCarValidator = new RacingCarValidator();
    }

    public void run() {
        String[] carNames = inputView.getCarNames().split(GameSetting.CAR_NAME_DELIMITER);
        racingCarValidator.validateCarNames(carNames);

        List<CarRequest> carRequests = RacingCarConverter.toCarRequests(carNames);
        int gameRound = inputView.getRound();
        racingCarValidator.validateGameRound(gameRound);

        execute(carRequests, gameRound);
    }

    public void execute(List<CarRequest> carRequests, int round) {
        RacingCarGame racingCarGame = new RacingCarGame(RacingCarConverter.toCars(carRequests), round, new RandomNumberMovable());
        outputView.printResultTitle();

        while (!racingCarGame.isFinish()) {
            outputView.print(racingCarGame.doNextRound().toString());
        }
        outputView.print(racingCarGame.selectWinners().toString());
    }

}
