package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IOSystem {

    private final Scanner sc;

    public IOSystem() {
        sc = new Scanner(System.in);
    }

    public List<String> getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();
        List<String> carNameList = List.of(carNames.split(","));
        for (String name : carNameList) {
            checkInvalidName(name);
        }
        if (hasDuplicatedName(carNameList)) {
            throw new RuntimeException();
        }
        return carNameList;
    }

    private boolean hasDuplicatedName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() < carNameList.size();
    }

    public void checkInvalidName(String name) {
        if (name == null || name.equals("") || name.length() > 5) {
            throw new RuntimeException();
        }
    }

    public void printWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            stringBuilder.append(winner.getName() + ", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    public void printGameResult(CarList carList) {
        System.out.println(carList);
    }

    public int getTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int trialNumber = Integer.parseInt(sc.next());
        if (trialNumber < 0) {
            throw new RuntimeException();
        }

        return trialNumber;
    }
}
