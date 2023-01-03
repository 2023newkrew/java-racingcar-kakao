package racingcar.domain.car;

import racingcar.domain.power.PowerGeneratable;

public class RacingCar {

    private static final String DEFAULT_CAR_NAME = "car";
    private final static int POWER_THRESHOLD = 4;
    private final static int MOVE_DISTANCE = 1;
    private final RacingCarName carName;
    private int pos;

    public RacingCar() {
        this(DEFAULT_CAR_NAME);
    }

    public RacingCar(String carName) {
        this.pos = 0;
        this.carName = new RacingCarName(carName);
    }
    public String getCarName() {
        return this.carName.getName();
    }

    public int getPos() {
        return this.pos;
    }

    public void move(PowerGeneratable powerGenerator) {
        accelerate(powerGenerator.generate());
    }

    private void accelerate(int power) {
        if (power >= this.POWER_THRESHOLD) {
            this.pos += MOVE_DISTANCE;
        }
    }

}
