/**
 * 레이싱 객체:
 * 자동차들의 정보를 가지고 있음
 * 라운드를 진행함
 * 다른거X 입력은 신경 안써야함 그냥 게임 돌리기만함
 */
package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int roundNum;

    Racing(List<Car> cars, int roundNum) { // 인풋은 이미 정상인걸 확인했다 치고 (뷰에서 확인한다함)
        this.cars = new ArrayList<>();
        this.cars = cars;
        this.roundNum = roundNum;
    }

    private void round() {
        for (Car car : cars) {
            int random = Utils.getRandomNumber();
            car.move(random);
        }
    }

    public List<Car> roundResult() {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car);
        }
        return result;
    }

    List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) winners.add(car.getName());
        }
        return winners;
    }

    int getRoundNum() {
        return roundNum;
    }
/*
    Car getCar(int index) {
        try {
            return cars.get(index);
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
*/
}
