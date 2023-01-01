package racingcar;

public class App {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        MovingStrategy movingStrategy = new RandomValueMovingStrategy();

        RacingCarService racingCarService = new RacingCarService(inputView, outputView, movingStrategy);

        racingCarService.run();
    }
}
