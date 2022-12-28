package racing.view;

import racing.model.Car;
import racing.repository.RacingCarRepository;

public class RacingOutputTemplate {
    private final RacingCarRepository racingCarRepository;

    public RacingOutputTemplate(RacingCarRepository racingCarRepository){
        this.racingCarRepository = racingCarRepository;
    }

    public void printResultString() {
        System.out.println("\n실행 결과");
    }

    public void printCurrentStatus(){
        for(Car car : racingCarRepository.getCars()){
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners() {
        String winners = String.join(", ", racingCarRepository.getWinners());
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
