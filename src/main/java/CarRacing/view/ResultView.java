package CarRacing.view;

import CarRacing.domain.CarName;
import CarRacing.domain.RacingLog;

import CarRacing.domain.RacingResult;
import CarRacing.util.StringUtil;
import java.util.List;

public class ResultView {
    private static void printRacingLog(RacingLog[] racingLog) {
        for (RacingLog car : racingLog) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printRacingLogs(List<RacingLog[]> RacingLogs) {
        System.out.println("실행 결과");
        for (RacingLog[] racingLog : RacingLogs) {
            printRacingLog(racingLog);
        }
    }

    public static void printWinners(List<CarName> winners) {
        System.out.println(StringUtil.joinStringList(",", StringUtil.convertCarNameListToStringList(winners)) + "가 최종 우승했습니다.");
    }

    public static void printRacingResult(RacingResult racingResult) {
        printRacingLogs(racingResult.getRacingLogs());
        printWinners(racingResult.getWinners());
    }
}
