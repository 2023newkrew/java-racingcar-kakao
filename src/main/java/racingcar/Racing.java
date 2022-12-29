/**
 * - 여러대의 자동차 정보를 가지고 있다
 * - 각 라운드마다 자동차를 전진하거나 정지한다
 *  - 랜덤 값이 4 이상일 경우 자동차를 전진한다
 *  - 랜덤 값이 3 이하일 경우 자동차를 정지한다
 * - 라운드가 종료될 때 마다 결과를 확인할 수 있다
 * - 게임이 종료된 후 우승자를 확인할 수 있다
 */
package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int roundNum;
    private int currentRoundNum;

    Racing(List<String> carNames, int roundNum) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.roundNum = roundNum;
        currentRoundNum = 0;
    }

    public void round() {
        for (Car car : cars) {
            int random = Utils.getRandomNumber();
            car.move(random);
        }
        currentRoundNum++;
    }

    public List<Car> getRoundResult() { //정보를 보내는 부분
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car);
        }
        return result;
    }

    public List<String> getWinner() { //정보를 보내는 부분
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isEnd() {
        return currentRoundNum == roundNum;
    }

}
