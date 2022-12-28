package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 프로그램의 UI로직을 담당하는 클래스입니다.
 * UI로직과 validation로직이 모두 들어가 있습니다.
 */
public class IOSystem {
    private final Scanner sc;
    final static String COMMA = ",";
    final static String SPACE = " ";

    public IOSystem() {
        sc = new Scanner(System.in);
    }

    public List<String> getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();

        List<String> carNameList = SplitCarNames(carNames);
        // 빈 문자열, 6자 이상 문자열 체크
        validateCarNameList(carNameList);

        checkDuplicatedCarName(carNameList);
        return carNameList;
    }

    private void checkDuplicatedCarName(List<String> carNameList) {
        if (hasDuplicatedName(carNameList)) {
            throw new RuntimeException();
        }
    }

    private void validateCarNameList(List<String> carNameList) {
        for (String name : carNameList) {
            checkInvalidName(name);
        }
    }

    private static List<String> SplitCarNames(String carNames) {
        return List.of(carNames.split(COMMA));
    }

    private boolean hasDuplicatedName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() < carNameList.size();
    }

    private void checkInvalidName(String name) {
        if (name == null || "".equals(name) || name.length() > 5) {
            throw new RuntimeException();
        }
    }

    public void printWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            stringBuilder.append(winner.getName() + COMMA + SPACE);
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
        checkNegative(trialNumber);

        return trialNumber;
    }

    private static void checkNegative(int trialNumber) {
        if (trialNumber < 0) {
            throw new RuntimeException();
        }
    }
}
