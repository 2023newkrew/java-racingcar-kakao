package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private String createCarPositionMessage(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i <= car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.append("\n").toString();
    }

    public void sendGameResultMessage() {
        System.out.println("실행 결과");
    }

    public void sendTurnResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(this.createCarPositionMessage(car));
        }
        System.out.println(sb);
    }

    public void sendWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        sb.append(String.join(", ", winnerNames));
        System.out.println(sb.append("가 최종 우승했습니다."));
    }
}
