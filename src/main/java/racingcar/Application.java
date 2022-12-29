package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCarFactory;
import racingcar.domain.collection.RacingCarCollection;
import racingcar.view.RacingCarView;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = RacingCarView.receiveCarNamesCsv();
        int runNumber = RacingCarView.receiveRunNumber();
        RacingCarGame racingCarGame = new RacingCarGame(runNumber, prepareCars(carNames));
        racingCarGame.start();
    }

    private static RacingCarCollection prepareCars(List<String> carNames) {
        List<RacingCar> cars = carNames.stream()
                .map(RacingCarFactory::createRacingCar)
                .collect(Collectors.toList());
        return new RacingCarCollection(cars);
    }
}
