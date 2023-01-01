package CarRacing.domain;

public class RacingLog {
    private CarName name;
    private CarPosition position;

    public RacingLog(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }
}
