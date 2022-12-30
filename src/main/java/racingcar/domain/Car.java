package racingcar.domain;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) throws RuntimeException {
        if(name == null || name.isEmpty())
            throw new RuntimeException("자동차의 이름이 없습니다.");
        if(name.length() > 5)
            throw new RuntimeException("자동차의 이름은 5자 이하로 적어야 합니다.");

        this.name = name;
        this.distance = 0;
    }

    public void forward(MovingStrategy movingStrategy) {
        if(movingStrategy.getMoveState()==MoveState.FORWARD)
            distance++;
    }

    public int getDistance(){
        return this.distance;
    }

    public String getName() {
        return name;
    }
}
