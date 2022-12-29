package racingcar.controller;

import racingcar.domain.CarContainer;
import racingcar.domain.GameResult;
import racingcar.domain.RoundRecord;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.CarWinnerDto;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    RacingCarView racingCarView;
    CarContainer carContainer;

    public RacingCarGame(RacingCarView racingCarView, CarContainer carContainer) {
        this.racingCarView = racingCarView;
        this.carContainer = carContainer;
    }

    public void start() {
        ArrayList<RoundRecord> roundRecords = new ArrayList<>();
        List<String> carNamesInput = racingCarView.receiveCarNamesCsv();
        int runNumber = racingCarView.receiveRunNumber();
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
        racingCarView.printWinners(
                carContainer.selectWinners()
                        .stream()
                        .map(CarWinnerDto::toDto)
                        .collect(Collectors.toList())
        );
    }
}
