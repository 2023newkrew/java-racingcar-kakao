package racingcar.controller;

import racingcar.service.RacingCarGame;
import racingcar.utils.RacingCarConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.dto.GameResult;
import racingcar.dto.CarDto;
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
        String[] carNames = inputView.getCarNames().split(",");
        racingCarValidator.validateCarNames(carNames);

        List<CarDto> carDtos = RacingCarConverter.toCarDtos(carNames);
        int gameRound = inputView.getRound();
        racingCarValidator.validateGameRound(gameRound);

        execute(carDtos, gameRound);
    }

    public void execute(List<CarDto> carDtos, int round) {
        RacingCarGame racingCarGame = new RacingCarGame(carDtos, round);
        outputView.printInitialStatus(createInitialStatus(carDtos));

        while (!racingCarGame.isFinish()) {
            GameResult gameResult = racingCarGame.doNextRound();
            outputView.print(gameResult.getIntermediateResult());
        }
        outputView.print(racingCarGame.selectWinners().getFinalResult());
    }

    public String createInitialStatus(List<CarDto> carDtos) {
        return new GameResult(carDtos).getIntermediateResult();
    }

}
