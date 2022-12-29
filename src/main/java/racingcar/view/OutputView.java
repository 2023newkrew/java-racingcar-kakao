package racingcar.view;

import racingcar.domain.CarInfo;
import racingcar.domain.GameInfo;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NOTICE_GAME_START = "실행 결과";
    private static final String NOTICE_CAR_STATUS = "%s : %s";
    private static final String NOTICE_GAME_RESULT = "%s가 최종 우승했습니다.";
    private static final String CAR_DISTANCE_UNIT = "-";

    public static void printInitialStatus(GameInfo gameInfo) {
        System.out.println(NOTICE_GAME_START);
        printRoundResult(gameInfo);
    }

    public static void printRoundResult(GameInfo gameInfo) {
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            System.out.println(String.format(NOTICE_CAR_STATUS,
                    carInfo.getName(), CAR_DISTANCE_UNIT.repeat(carInfo.getDistance())));
        }
        System.out.println();
    }

    public static void printGameResult(List<CarInfo> winners) {
        List<String> winnerNames = winners.stream()
                .map(CarInfo::getName)
                .collect(Collectors.toList());
        System.out.println(String.format(NOTICE_GAME_RESULT,
                String.join(",", winnerNames)));
    }
}
