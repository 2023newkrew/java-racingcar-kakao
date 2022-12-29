package racingcar.controller;


import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.InputViewKorean;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputViewKorean(System.in);
        Racing racing = new Racing();
        racing.generateCars(inputView.scanNames());
        racing.proceedRounds(inputView.scanTrialCount());
        System.out.println("최종결과");
        System.out.println(racing.joinWinners() + "가 최종 우승했습니다.");
    }
}
