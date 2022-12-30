package racingcar.view;

import racingcar.dto.CarInfo;
import racingcar.dto.GameInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IOHelper {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String INITIAL_STATUS_HEADER_MESSAGE = "실행 결과";
    public static final String WRONG_INPUT_MESSAGE = "잘못된 입력값입니다.";

    private static final Scanner sc = new Scanner(System.in);
    private final Validator validator;

    public IOHelper(Validator validator) {
        this.validator = validator;
    }

    // 사용자로부터 자동차의 이름 입력 받아 문자열 리스트로 반환
    public List<String> getNamesInput() {
        List<String> names = new ArrayList<>();

        while (true) {
            System.out.println(INPUT_CAR_NAMES_MESSAGE);
            String input = sc.nextLine();
            if (validator.isValidNamesInput(input)) {
                names = getTrimNames(input);
                break;
            }
            System.out.println(WRONG_INPUT_MESSAGE);
        }
        return names;
    }

    // 문자열을 쉼표를 기준으로 잘라 리스트로 반환
    public List<String> getTrimNames(String input) {
        List<String> names = List.of(input.split(","));
        List<String> trimNames = names.stream()
                .map(name -> name.trim())
                .collect(Collectors.toList());
        return trimNames;
    }

    // 사용자로부터 이동 시도 횟수를 입력 받아 정수로 반환
    public int getRoundInput() {
        String input = "";
        while (true) {
            System.out.println(INPUT_TRY_COUNT_MESSAGE);
            input = sc.nextLine();
            if (validator.isValidRoundInput(input)) {
                break;
            }
            System.out.println(WRONG_INPUT_MESSAGE);
        }
        return Integer.parseInt(input);
    }

    // 각 자동차의 이름과 위치를 출력
    public void printCarStatus(GameInfo gameInfo) {
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            System.out.println(carInfo.getName() + " : " + "-".repeat(carInfo.getPosition()));
        }
        System.out.println();
    }

    // 게임 결과(우승자) 출력
    public void printGameResult(List<CarInfo> winners) {
        List<String> winnerNames = winners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.toList());
        String result = String.join(",", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    // 자동차들의 이름 및 거리 최초 출력(게임 시작시 사용)
    public void printInitialStatus(GameInfo gameInfo) {
        System.out.println(INITIAL_STATUS_HEADER_MESSAGE);
        printCarStatus(gameInfo);
    }

    // Scanner 종료
    public void close() {
        sc.close();
    }
}