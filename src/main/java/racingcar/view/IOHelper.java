package racingcar.view;

import racingcar.dto.CarInfo;
import racingcar.dto.GameInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IOHelper {

    public static final int MAX_NAME_LENGTH = 5;
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String INITIAL_STATUS_HEADER_MESSAGE = "실행 결과";
    public static final String WRONG_INPUT_MESSAGE = "잘못된 입력값입니다.";

    private static final Scanner sc = new Scanner(System.in);

    // 사용자로부터 자동차의 이름 입력 받아 문자열 리스트로 반환
    public static List<String> getNamesInput() {
        List<String> names = new ArrayList<>();

        while (names.size()==0 || !validateNames(names)) {
            System.out.println(INPUT_CAR_NAMES_MESSAGE);
            String input = sc.nextLine();
            names = getTrimNames(input);
        }
        return names;
    }

    // 문자열을 쉼표를 기준으로 잘라 리스트로 반환
    public static List<String> getTrimNames(String input) {
        List<String> names = List.of(input.split(","));
        List<String> trimNames = names.stream()
                .map(name -> name.trim())
                .collect(Collectors.toList());
        return trimNames;
    }

    // 이름들이 담긴 문자열 리스트의 유효성 검증
    public static boolean validateNames(List<String> names) {
        boolean flag = true;

        for (String name : names) {
            flag = validateName(flag, name);
        }
        if (!flag) {
            System.out.println(WRONG_INPUT_MESSAGE);
        }
        return flag;
    }

    // 이름의 유효성 검증
    private static boolean validateName(boolean flag, String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            return false;
        }
        return flag;
    }

    // 사용자로부터 이동 시도 횟수를 입력 받아 정수로 반환
    public static int getRoundInput() {
        String roundInput = "";
        boolean flag = true;
        while (flag) {
            System.out.println(INPUT_TRY_COUNT_MESSAGE);
            roundInput = sc.nextLine();
            flag = !validateRound(roundInput);
        }
        return Integer.parseInt(roundInput);
    }

    // 입력 받은 시도 횟수의 유효성 검증
    private static boolean validateRound(String roundInput) {
        if (!isInteger(roundInput)) {
            System.out.println(WRONG_INPUT_MESSAGE);
            return false;
        }
        if (Integer.parseInt(roundInput) < 0) {
            System.out.println(WRONG_INPUT_MESSAGE);
            return false;
        }

        return true;
    }

    // 문자열에 대한 정수형 변경 가능 여부 반환
    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // 각 자동차의 이름과 위치를 출력
    public static void printCarStatus(GameInfo gameInfo) {
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            System.out.println(carInfo.getName() + " : " + "-".repeat(carInfo.getPosition()));
        }
        System.out.println();
    }

    // 게임 결과(우승자) 출력
    public static void printGameResult(List<CarInfo> winners) {
        List<String> winnerNames = winners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.toList());
        String result = String.join(",", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    // 자동차들의 이름 및 거리 최초 출력(게임 시작시 사용)
    public static void printInitialStatus(GameInfo gameInfo) {
        System.out.println(INITIAL_STATUS_HEADER_MESSAGE);
        printCarStatus(gameInfo);
    }
}