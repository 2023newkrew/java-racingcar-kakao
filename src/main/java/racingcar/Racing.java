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

/*
    boolean registerCarNames(String input) {
        String[] temp = input.split(",");
        if (!lengthCheck(temp)) return false;

        for (String name : temp) {
            cars.add(new Car(name));
        }
        return true;
    }

    private boolean lengthCheck(String[] nameList) {
        boolean check = true;
        for (String name : nameList) {
            check &= (name.length() <= 5);
        }
        return check;
    }

    boolean registerCarRoundNum(String input) {
        try {
            roundNum = Integer.parseInt(input);
            return positiveCheck(roundNum);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean positiveCheck(int roundNum) {
        return roundNum > 0;
    }
*/
    boolean round() {
        for (Car car : cars) {
            int random = Utils.getRandomNumber();
            car.move(random);
        }
        return true;
    }
/*
    String roundResult() {
        String temp = "";
        for (Car car : cars) {
            temp += car.getName() + "," + car.getPosition() + ",";
        }
        return temp;
    }

    String getWinner() {
        int maxPosition = 0;
        String winnerList = "";
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars) {
            winnerList += car.matchPosition(maxPosition);
        }
        return winnerList;
    }

    int getRoundNum() {
        return roundNum;
    }

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
