package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RandomMovingStrategy;
import racingcar.dto.CarDTO;
import racingcar.dto.WinnerDTO;
import racingcar.util.StringParser;
import racingcar.view.RacingUI;

public class RacingController {

    private final RacingUI racingUI = new RacingUI();
    private Racing racing;

    public void startRace() {
        this.setUpRace();
        while (this.racing.isRacing()) {
            this.racing.proceedTurn();
            List<Car> currentCars = this.racing.getRaceStatus();
            List<CarDTO> statusDTOs = currentCars.stream().map(CarDTO::from).collect(Collectors.toList());
            racingUI.displayPosition(statusDTOs);
        }
        endRace();
    }

    private void endRace() {
        List<Car> winners = this.racing.getWinners();
        List<WinnerDTO> winnerDTOs = winners.stream().map(WinnerDTO::from).collect(Collectors.toList());
        racingUI.displayWinner(winnerDTOs);
    }

    private void setUpRace() {
        String names = racingUI.getNames();
        List<String> parsedNames = StringParser.parse(names);
        List<Car> cars = parsedNames.stream().map(Car::new).collect(Collectors.toList());

        String turn = racingUI.getTurn();
        int parsedTurn = Integer.parseInt(turn);

        this.racing = new Racing(cars, parsedTurn, new RandomMovingStrategy());
    }
}
