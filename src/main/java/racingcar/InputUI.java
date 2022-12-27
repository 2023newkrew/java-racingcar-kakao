package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUI {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> inputCarNameList() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = br.readLine();
        List<String> carNameList = Arrays.asList(input.split(","));
        while (!validation(carNameList)) {
            System.out.println("5글자 이하의 이름만 가능합니다.");
            input = br.readLine();
            carNameList = Arrays.asList(input.split(","));
        }

        return carNameList;
    }

    private static boolean validation(List<String> cars) {
        boolean isValid = true;
        for (String car : cars) {
            isValid = isValid && car.length() <= 5;
        }

        return isValid;
    }

    public static int inputTurn() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = br.readLine();
        Matcher matcher = Pattern.compile("(\\d+)").matcher(input);
        while (!matcher.matches()){
            System.out.println("숫자만 입력 가능합니다.");
            input = br.readLine();
            matcher = Pattern.compile("(\\d+)").matcher(input);
        }

        return Integer.parseInt(input);
    }
}
