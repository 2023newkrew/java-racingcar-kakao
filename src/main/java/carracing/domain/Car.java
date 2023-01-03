package carracing.domain;

public class Car{
    private final CarName carName;
    private Integer position;

    public Car(String carName) {
        this(carName, 1);
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = position;
    }

    public void proceedNextTurn(Boolean proceed) {
        if (proceed) {
            this.position += 1;
        }
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getCarName() {
        return carName.getName();
    }
}
