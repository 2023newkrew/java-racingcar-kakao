package racingcar.factory;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;

/**
 * Car 인터페이스의 구현체를 생성하는 CarFactory
 * name의 형식에 따라 RacingCar 외의 다른 Car의 구현체를 생성할 수 있는 확장성을 고려하여 정적 팩토리 메소드를 사용
 */
public class CarFactory {
    public static Car createCar(String name) {
        return new RacingCar(name);
    }

    public static Car createCar(String name, int position) {
        return new RacingCar(name, position);
    }
}
