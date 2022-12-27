package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        GameView gameView = new GameView();
        List<CarDto> carDtos = createCarList(gameView.getCarNames());
        int count = gameView.getCount();

        gameView.printResultTitle();
        gameView.printResult(createInitialStatus(carDtos));
        execute(gameView, carDtos, count);
    }

    public static void execute(GameView gameView, List<CarDto> carDtos, int count) {
        RacingCarGame racingCarGame = new RacingCarGame(carDtos, count);

        while (!racingCarGame.isFinish()) {
            GameResult gameResult = racingCarGame.play();
            gameView.printResult(gameResult.getIntermediateResult());
        }

        gameView.printResult(racingCarGame.selectWinners().getFinalResult());
    }

    public static String createInitialStatus(List<CarDto> carDtos) {
        return new GameResult(carDtos).getIntermediateResult();
    }

    public static List<CarDto> createCarList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(carName -> new CarDto(carName, 1))
                .collect(Collectors.toList());
    }
}
