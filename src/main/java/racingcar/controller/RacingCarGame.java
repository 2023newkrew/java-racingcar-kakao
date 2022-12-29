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

    CarContainer carContainer;

    public RacingCarGame(CarContainer carContainer) {
        this.carContainer = carContainer;
    }

    public void start() {
        ArrayList<RoundRecord> roundRecords = new ArrayList<>();
        List<String> carNamesInput = RacingCarView.receiveCarNamesCsv();
        int runNumber = RacingCarView.receiveRunNumber();
        for (int i = 0; i < runNumber; i++) {
            ArrayList<CarStatusDto> carStatusList = new ArrayList<>();
            carContainer.moveAll();
            carContainer.getCars()
                    .stream()
                    .map(CarStatusDto::toDto)
                    .forEach(carStatusList::add);
            roundRecords.add(new RoundRecord(carStatusList));
        }
        RacingCarView.printGameResult(new GameResult(roundRecords));
        RacingCarView.printWinners(
                carContainer.selectWinners()
                        .stream()
                        .map(CarWinnerDto::toDto)
                        .collect(Collectors.toList())
        );
    }
}
