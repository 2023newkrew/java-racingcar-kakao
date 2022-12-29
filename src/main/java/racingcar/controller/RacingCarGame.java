package racingcar.controller;

import racingcar.domain.CarContainer;
import racingcar.domain.GameResult;
import racingcar.domain.RoundRecord;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.CarWinnerDto;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.RacingCarFactory;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private int remainingRound;

    private CarContainer carContainer;

    public RacingCarGame() {
        setCarContainer();
        setTotalRound();
    }

    public void start() {
        ArrayList<RoundRecord> roundRecords = new ArrayList<>();
        while (!isGameEnd()) {
            roundRecords.add(runRound());
        }
        RacingCarView.printGameResult(new GameResult(roundRecords));
        RacingCarView.printWinners(selectWinners());
    }

    private void setTotalRound() {
        remainingRound = RacingCarView.receiveRunNumber();
    }

    private void setCarContainer() {
        List<String> carNames = RacingCarView.receiveCarNamesCsv();
        List<RacingCar> cars = new ArrayList<>();
        carNames.forEach(carName -> cars.add(RacingCarFactory.createRacingCar(carName)));
        carContainer = new CarContainer(cars);
    }

    private RoundRecord runRound() {
        ArrayList<CarStatusDto> carStatusList = new ArrayList<>();
        carContainer.moveAll();
        carContainer.getCars()
                .stream()
                .map(CarStatusDto::toDto)
                .forEach(carStatusList::add);
        remainingRound--;
        return new RoundRecord(carStatusList);
    }

    private List<CarWinnerDto> selectWinners() {
        return carContainer.selectWinners()
                .stream()
                .map(CarWinnerDto::toDto)
                .collect(Collectors.toList());
    }

    private boolean isGameEnd() {
        return remainingRound <= 0;
    }
}
