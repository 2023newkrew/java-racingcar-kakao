package racingcar;


public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Racing racing = new Racing();
        racing.generateCars(input.scanNames());
        racing.proceedRounds(input.scanTrialCount());
        System.out.println("최종결과");
        System.out.println(racing.joinWinners() + "가 최종 우승했습니다.");
    }
}
