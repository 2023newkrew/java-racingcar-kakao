package CarRacing.domain;

public class RacingLog {
    private CarName name;
    private int position;

    public RacingLog(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
