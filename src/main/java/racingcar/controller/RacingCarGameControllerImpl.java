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
        int runCount = inputView.inputRunCount();
        outputView.printRunResult();
        runAndPrint(runCount);
        outputView.printFinalResult(racingCarGame.getWinnerNames());
    }

    private void runAndPrint(int runCount) {
        for(int i = 0; i< runCount; i++){
            racingCarGame.run();
            outputView.printEachRunResult(racingCarGame.getCarResults());
        }
    }

}
