package racingcar.view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> inputCarNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();
        checkNullAndEmpty(input);
        List<String> carNameList = List.of(input.split(","));
        return validateCarList(carNameList);
    }

    public static List<String> validateCarList(List<String> carNameList) {
        if (carNameList == null || carNameList.isEmpty()) {
            throw new IllegalArgumentException("입력이 잘못 되었습니다.");
        }

        for (String carName : carNameList) {
            checkNullAndEmpty(carName);
            validateMaxLength(carName);
        }

        return carNameList;
    }

    private static void checkNullAndEmpty(String car) {
        if (car == null || car.isBlank()) {
            throw new IllegalArgumentException("차 이름은 한 글자 이상이어야 합니다.");
        }
    }

    private static void validateMaxLength(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("차 이름은 5글자 이하여야 합니다.");
        }
    }

    public static int inputTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = sc.nextLine();
        validateTurn(input);

        return Integer.parseInt(input);
    }

    public static void validateTurn(String turn) {
        Matcher matcher = Pattern.compile("(\\d+)").matcher(turn);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }
}
