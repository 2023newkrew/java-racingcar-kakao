package racingcar.step1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNameList = InputUI.inputCarNameList();
        int turn = InputUI.inputTurn();
        RacingGame racingGame = new RacingGame(makeCarList(carNameList), turn);

        System.out.println("실행 결과");
        OutputUI.printGameResult(racingGame.play());
    }

    private static List<Car> makeCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
