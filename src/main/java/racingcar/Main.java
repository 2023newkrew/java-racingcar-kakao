package racingcar;


public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Racing racing = new Racing(new RandomGeneratorImpl());
        String[] carNames = input.scanNames();
        input.validate(carNames);
        racing.generateCars(carNames);
        racing.proceedRounds(input.scanTrialNumber());
        System.out.println("최종결과");
        System.out.println(racing.joinWinners() + "가 최종 우승했습니다.");
    }
}
