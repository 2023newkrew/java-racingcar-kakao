package racingcar.controller;

import racingcar.domain.collection.RacingCarCollection;
import racingcar.domain.dto.GameResultDto;
import racingcar.domain.dto.RaceRecordDto;
import racingcar.exception.BusinessException;
import racingcar.exception.ErrorCode;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final RacingCarCollection cars;

    public RacingCarGame(RacingCarCollection cars) {
        this.cars = cars;
    }

    public void start(final int totalRound) {
        validateTotalRoundIsPositive(totalRound);
        List<RaceRecordDto> raceRecords = new ArrayList<>();
        int remainingRound = totalRound;

        raceRecords.add(RaceRecordDto.of(cars));
        while (remainingRound > 0) {
            cars.moveAll();
            raceRecords.add(RaceRecordDto.of(cars));
            remainingRound--;
        }
        RacingCarView.printGameResult(GameResultDto.of(raceRecords));
        RacingCarView.printWinners(cars.selectWinners());
    }

    private void validateTotalRoundIsPositive(final int totalRound) {
        if (totalRound <= 0) {
            throw new BusinessException(ErrorCode.OUT_OF_RANGE_EXCEPTION);
        }
    }
}
