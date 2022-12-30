package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * IOSystem과 CarList를 합쳐 Service로 구현
 * IOSystem에 있는 validation logic을 여기에서 진행합니다.
 */
public class ValidationService {

    public ValidationService() {
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

    public int validateTrialUserInput(int trialNumber) {
        checkNegative(trialNumber);
        return trialNumber;
    }

    private void checkNegative(int trialNumber) {
        if (trialNumber < 0) {
            throw new RuntimeException();
        }
    }
}
