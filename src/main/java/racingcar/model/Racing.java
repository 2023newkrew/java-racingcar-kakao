/**
 * - 여러대의 자동차 정보를 가지고 있다
 * - 각 라운드마다 자동차를 전진하거나 정지한다
 * - 랜덤 값이 4 이상일 경우 자동차를 전진한다
 * - 랜덤 값이 3 이하일 경우 자동차를 정지한다
 * - 라운드가 종료될 때 마다 결과를 확인할 수 있다
 * - 게임이 종료된 후 우승자를 확인할 수 있다
 */
package racingcar.model;

import racingcar.dto.RoundResultDto;
import racingcar.dto.WinnerDto;
import racingcar.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> cars;
    private final int roundNum;
    private int currentRoundNum;

    public Racing(List<String> carNames, int roundNum) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.roundNum = roundNum;
        currentRoundNum = 0;
    }

    public void round() { //한 라운드를 진행한다. 즉, 모든 차에 대해 전진 혹은 정지를 진행한다
        for (Car car : cars) {
            int random = Utils.getRandomNumber();
            car.move(random);
        }
        currentRoundNum++;
    }

    public RoundResultDto returnCarState() { //현재 자동차의 상태를 반환한다
        return new RoundResultDto(cars);
    }

    public WinnerDto returnWinners() { //게임의 승자를 출력한다
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            addWinner(winners, car, maxPosition);
        }
        return new WinnerDto(winners);
    }

    private int getMaxPosition() { //returnWinners를 위한 서브루틴1
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    private void addWinner(List<String> winners, Car car, int maxPosition) { //returnWinners를 위한 서브루틴2
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isEnd() { //게임이 종료되었는지 반환한다
        return currentRoundNum == roundNum;
    }

}