package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IOHelper {

    public static final int MAX_NAME_LENGTH = 5;
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
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = sc.nextLine();
            names = getTrimNames(input);
        }
        return names;
    }

    public List<String> getTrimNames(String input) {
        List<String> names = List.of(input.split(","));
        List<String> trimNames = names.stream()
                .map(name -> name.trim())
                .collect(Collectors.toList());
        return trimNames;
    }

    public boolean validateNames(List<String> names) {
        boolean flag = true;

        for (String name : names) {
            flag = validateName(flag, name);
        }
        if (!flag) {
            System.out.println("잘못된 입력값입니다.");
        }
        return flag;
    }

    private boolean validateName(boolean flag, String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            return false;
        }
        return flag;
    }

    public int getRoundInput() {
        String roundInput = "";
        boolean flag = true;
        while (flag) {
            System.out.println("시도할 회수는 몇회인가요?");
            roundInput = sc.nextLine();
            flag = !validateRound(roundInput);
        }
        return Integer.parseInt(roundInput);
    }

    private boolean validateRound(String roundInput) {
        try {
            Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력값입니다.");
            return false;
        }
        return true;
    }

    public void printRoundResult(GameInfo gameInfo) {
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            System.out.println(carInfo.getName() + " : " + "-".repeat(carInfo.getPosition()));
        }
        System.out.println();
    }

    public void printGameResult(List<CarInfo> winners) {
        List<String> winnerNames = winners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.toList());
        String result = String.join(",", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public void printInitialStatus(GameInfo gameInfo) {
        System.out.println("실행 결과");
        printRoundResult(gameInfo);
    }
}
