package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner sc;

    private static final String NOTICE_INVALID_INPUT = "잘못된 입력값입니다.";;
    private static final String NOTICE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NOTICE_GAME_ROUND_CNT = "시도할 회수는 몇회인가요?";
    private static final int CAR_NAME_MAX_LENGTH = 5;
    

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public List<String> getNamesInput() {
        List<String> names = new ArrayList<>();

        while (names.isEmpty() || !isValidNames(names)) {
            System.out.println(NOTICE_CAR_NAME);

            String input = sc.nextLine();
            names = getTrimNames(input);
        }
        return names;
    }

    private List<String> getTrimNames(String input) {
        String[] names = input.split(",");

        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private boolean isValidNames(List<String> names) {
        boolean isValid = names.stream()
                .allMatch(this::isValidName);

        if (!isValid) {
            System.err.println(NOTICE_INVALID_INPUT);
        }
        return isValid;
    }

    private boolean isValidName(String name) {
        return name.length() <= CAR_NAME_MAX_LENGTH;
    }

    public int getRoundInput() {
        String roundInput = "";
        boolean flag = true;
        while (flag) {
            System.out.println(NOTICE_GAME_ROUND_CNT);

            roundInput = sc.next();
            flag = !isValidRoundCount(roundInput);
        }
        return Integer.parseInt(roundInput);
    }

    private boolean isValidRoundCount(String roundInput) {
        try {
            Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            System.err.println(NOTICE_INVALID_INPUT);
            return false;
        }
        return true;
    }

}
