package racingcar.controller;

import racingcar.domain.CarContainer;
import racingcar.domain.GameResult;
import racingcar.domain.RoundRecord;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.model.Car;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    RacingCarView racingCarView;
    CarContainer carContainer;

    public RacingCarGame() {
        racingCarView = new RacingCarView();
        carContainer = new CarContainer();
    }

    public void start() {
        ArrayList<RoundRecord> roundRecords = new ArrayList<>();
        List<String> carNamesInput = racingCarView.receiveCarNamesCsv();
        int runNumber = racingCarView.receiveRunNumber();
        for (String carName : carNamesInput) {
            carContainer.add(new Car(carName));
        }
        for (int i = 0; i < runNumber; i++) {
            ArrayList<CarStatusDto> carStatusList = new ArrayList<>();
            carContainer.moveAll();
            carContainer.getCars()
                    .stream()
                    .map(CarStatusDto::toDto)
                    .forEach(carStatusList::add);
            roundRecords.add(new RoundRecord(carStatusList));
        }
        racingCarView.printGameResult(new GameResult(roundRecords));
        racingCarView.printWinners(carContainer.selectWinners());
    }
}
