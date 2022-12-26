package racingcar.domain;

import java.util.ArrayList;
import racingcar.AppConfig;
import racingcar.generator.RandomNumberGenerator;

public class RacingCarGameImpl implements RacingCarGame {
    private RandomNumberGenerator randomNumberGenerator;
    private ArrayList<Car> cars = new ArrayList<>();

    public RacingCarGameImpl(AppConfig appConfig) {
        randomNumberGenerator = appConfig.getRandomNumberGenerator();
    }

    @Override
    public void run(int times) {
        for(int i=0; i<times; i++) {
            cars.forEach(car -> car.move(randomNumberGenerator.generator()));
        }
    }

    @Override
    public void add(String carName){
        cars.add(new RacingCar(carName));
    }

}
