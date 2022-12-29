package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUI {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> inputCarNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();
        List<String> carNameList = List.of(input.split(","));
        while (!validateCarNames(carNameList)) {
            System.out.println("5글자 이하의 이름만 가능합니다.");
            input = sc.nextLine();
            carNameList = List.of(input.split(","));
        }

        return carNameList;
    }

    private static boolean validateCarNames(List<String> cars) {
        boolean isValid = true;
        for (String car : cars) {
            isValid = isValid && validateMaxLength(car);
            checkNullAndEmpty(car);
        }

        return isValid;
    }

    private static void checkNullAndEmpty(String car) {
        if(car == null || car.isEmpty()) throw new IllegalArgumentException("차 이름은 한 글자 이상이어야 합니다.");
    }

    private static boolean validateMaxLength(String car) {
        return car.length() <= 5;
    }

    public static int inputTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("(\\d+)").matcher(input);
        while (!matcher.matches()) {
            System.out.println("숫자만 입력 가능합니다.");
            input = sc.nextLine();
            matcher = Pattern.compile("(\\d+)").matcher(input);
        }

        return Integer.parseInt(input);
    }
}
