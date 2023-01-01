package racingcar;

public class RacingCarService implements Runnable {

    private final InputView inputView;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;


    public RacingCarService(InputView inputView, OutputView outputView, MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void run() {
        Cars cars = new Cars(inputView.getCars());
        int round = inputView.getRounds();

        RacingGame racingGame = new RacingGame(movingStrategy, cars, round);
        outputView.printInitialStatus(racingGame.getCars());
        while(!racingGame.isEnd()) {
            racingGame.race();
            outputView.printCars(racingGame.getCars());
        }
        outputView.printWinners(racingGame.getWinners());
    }

}
