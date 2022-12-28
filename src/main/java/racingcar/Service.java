package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * IOSystem과 CarList를 합쳐 Service로 구현
 * IOSystem에 있는 validation logic을 여기에서 진행합니다.
 */
public class Service {
    private final IOSystem ioSystem;
    private final CarList carList;
    private final static String COMMA = ",";

    public Service() {
        ioSystem = new IOSystem();
        carList = new CarList();
    }

    public List<String> carNameUserInputService() {
        List<String> carNameList = ioSystem.carNamesUserInput();
        validateInputCarNames(carNameList);
        return carNameList;
    }

    public void validateInputCarNames(List<String> carNameList) {
        // 빈 문자열, 6자 이상 문자열 체크
        validateEmptyAndLength(carNameList);
        // 중복되는 차 이름이 있는지 체크
        checkDuplicatedCarName(carNameList);
    }

    private void validateEmptyAndLength(List<String> carNameList) {
        for (String name : carNameList) {
            checkInvalidName(name);
        }
    }

    private void checkInvalidName(String name) {
        if (name == null || "".equals(name) || name.length() > 5) {
            throw new RuntimeException();
        }
    }

    private void checkDuplicatedCarName(List<String> carNameList) {
        if (hasDuplicatedName(carNameList)) {
            throw new RuntimeException();
        }
    }

    private boolean hasDuplicatedName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() < carNameList.size();
    }

    public int trialUserInputService() {
        int trialNumber = ioSystem.trialNumberUserInput();
        checkNegative(trialNumber);
        return trialNumber;
    }

    private static void checkNegative(int trialNumber) {
        if (trialNumber < 0) {
            throw new RuntimeException();
        }
    }

    public void addCarsInCarListService(List<String> carNamesInput) {
        for (String carName : carNamesInput) {
            carList.add(new Car(carName));
        }
    }

    public void playRacingGameAndResultService(int trialNumber) {
        System.out.println("실행 결과");
        ioSystem.printGameResult(carList);
        for (int i = 0; i < trialNumber; i++) {
            carList.moveAll();
            ioSystem.printGameResult(carList);
        }
    }

    public void printWinnersService() {
        ioSystem.printWinners(carList.getWinners());
    }
}
