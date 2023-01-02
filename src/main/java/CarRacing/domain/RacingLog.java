package CarRacing.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingLog racingLog = (RacingLog) o;
        return Objects.equals(name, racingLog.name) && Objects.equals(position, racingLog.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
