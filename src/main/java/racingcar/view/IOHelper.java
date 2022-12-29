package racingcar.view;

import racingcar.domain.CarInfo;
import racingcar.domain.GameInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IOHelper {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_GAME_ROUND_COUNT = "시도할 회수는 몇회인가요?";
    private static final int INPUT_CAR_NAME_MAX_LENGTH = 5;

    private static final String OUTPUT_INITIAL = "실행 결과";
    private static final String OUTPUT_INVALID_INPUT = "잘못된 입력값입니다.";
    private static final String OUTPUT_CAR_STATUS = "%s : %s";
    private static final String OUTPUT_CAR_DISTANCE_UNIT = "-";
    private static final String OUTPUT_WINNER = "%s가 최종 우승했습니다.";

    private Scanner sc;

    public IOHelper() {
        this.sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public List<String> getNamesInput() {
        List<String> names = new ArrayList<>();

        while (names.size()==0 || !validateNames(names)) {
            System.out.println(INPUT_CAR_NAME);
            String input = sc.nextLine();
            names = getTrimNames(input);
        }
        return names;
    }

    public List<String> getTrimNames(String input) {
        String[] names = input.split(",");

        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public boolean validateNames(List<String> names) {
        boolean flag = true;
        for (String name : names) {
            flag = validateName(flag, name);
        }

        if (!flag) {
            System.out.println(OUTPUT_INVALID_INPUT);
        }
        return flag;
    }

    private boolean validateName(boolean flag, String name) {
        if (name.length() > INPUT_CAR_NAME_MAX_LENGTH) {
            return false;
        }
        return flag;
    }

    public int getRoundInput() {
        String roundInput = "";
        boolean flag = true;
        while (flag) {
            System.out.println(INPUT_GAME_ROUND_COUNT);
            roundInput = sc.next();
            flag = !validateRound(roundInput);
        }
        return Integer.parseInt(roundInput);
    }

    private boolean validateRound(String roundInput) {
        try {
            Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            System.out.println(OUTPUT_INVALID_INPUT);
            return false;
        }
        return true;
    }

    public void printInitialStatus(GameInfo gameInfo) {
        System.out.println(OUTPUT_INITIAL);
        printRoundResult(gameInfo);
    }

    public void printRoundResult(GameInfo gameInfo) {
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            System.out.println(String.format(OUTPUT_CAR_STATUS,
                    carInfo.getName(), OUTPUT_CAR_DISTANCE_UNIT.repeat(carInfo.getDistance())));
        }
        System.out.println();
    }

    public void printGameResult(List<CarInfo> winners) {
        List<String> winnerNames = winners.stream()
                .map(CarInfo::getName)
                .collect(Collectors.toList());
        System.out.println(String.format(OUTPUT_WINNER,
                String.join(",", winnerNames)));
    }
}
