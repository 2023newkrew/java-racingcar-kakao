package racing;

import racing.domain.Car;
import racing.domain.Racing;
import racing.domain.Result;
import racing.view.In;
import racing.view.Out;

import java.util.List;

public class Game {

    private final static String INPUT_NAMES_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String INPUT_COUNT_REQUEST = "시도할 회수는 몇회인가요?";
    static Racing racing = new Racing();
    static Result result = new Result();
    static Car[] carList;

    public static void handleNames() {
        Out.printText(INPUT_NAMES_REQUEST);
        String inputNames = In.inputNames();
        carList = racing.createCars(inputNames);
    }

    public static void playRacing() {
        Out.printText(INPUT_COUNT_REQUEST);
        int inputCount = In.inputCount();
        Out.printText("실행 결과");
        Out.printResult(carList);
        for (int count = 0; count < inputCount; count++) {
            carList = racing.oneCycle(carList);
            Out.printResult(carList);
        }
    }

    public static void winnerResult() {
        List<String> winners = result.getWinner(carList);
        Out.printWinners(winners);
    }

    public static void main(String[] args) {
        handleNames();
        playRacing();
        winnerResult();
    }

}
