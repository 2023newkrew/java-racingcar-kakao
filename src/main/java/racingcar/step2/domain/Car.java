package racingcar.step2.domain;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    public Car(final String name){

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
        if (name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

}
