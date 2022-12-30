package racingcar.controller;

import racingcar.domain.collection.RacingCarCollection;
import racingcar.domain.dto.GameResultDto;
import racingcar.domain.dto.RaceRecordDto;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private int remainingRound;

    private final RacingCarCollection cars;

    public RacingCarGame(int remainingRound, RacingCarCollection cars) {
        this.remainingRound = remainingRound;
        this.cars = cars;
    }

    public void start() {
        List<RaceRecordDto> raceRecords = new ArrayList<>();
        raceRecords.add(RaceRecordDto.of(cars));
        while (!isGameEnd()) {
            raceRecords.add(race());
        }
        RacingCarView.printGameResult(GameResultDto.of(raceRecords));
        RacingCarView.printWinners(cars.selectWinners());
    }

    private RaceRecordDto race() {
        cars.moveAll();
        remainingRound--;
        return RaceRecordDto.of(cars);
    }

    private boolean isGameEnd() {
        return remainingRound <= 0;
    }
}
