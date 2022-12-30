package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner sc;

    private static final String NOTICE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NOTICE_GAME_ROUND_CNT = "시도할 회수는 몇회인가요?";

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public List<String> getNamesInput() {
        List<String> names = new ArrayList<>();

        while (!Validator.isValidCarNames(names)) {
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


    public int getRoundInput() {
        String roundInput = "";
        boolean flag = true;
        while (flag) {
            System.out.println(NOTICE_GAME_ROUND_CNT);
            roundInput = sc.next();

            flag = !Validator.isValidGameRoundCnt(roundInput);
        }
        return Integer.parseInt(roundInput);
    }

}
