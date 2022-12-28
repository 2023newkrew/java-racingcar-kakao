package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameControllerImpl implements RacingCarGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarGame racingCarGame;

    public RacingCarGameControllerImpl(InputView inputView, OutputView outputView, RacingCarGame racingCarGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarGame = racingCarGame;
    }

    @Override
    public void play() {
        outputView.printStartMessage();
        racingCarGame.add(inputView.inputName());
        outputView.printAskRunCount();
        outputView.printRunResult();
        runAndPrint(inputView.inputRunCount());
        outputView.printFinalResult(racingCarGame.getWinnerNames());
    }

    private void runAndPrint(int times) {
        for(int i = 0; i< times; i++){
            racingCarGame.run();
            outputView.printEachRunResult(racingCarGame.getCarResults());
        }
    }

}
