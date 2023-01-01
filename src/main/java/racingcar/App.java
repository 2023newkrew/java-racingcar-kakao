package racingcar;

public class App {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        Referee referee = new Referee();
        MovingStrategy movingStrategy = new RandomValueMovingStrategy();

        RacingCarService racingCarService = new RacingCarService(inputView, referee, outputView, movingStrategy);

        racingCarService.run();
    }
}
