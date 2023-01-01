package racing.domain;

import static racing.constant.MessageConstant.INVALID_METHOD_CALL_EXCEPTION;

public class ImmutableCar implements Car{

    private final int position;
    private final Name name;

    public ImmutableCar(Car car) {
        this.name = new Name(car.getName());
        this.position = car.getPosition();
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException(INVALID_METHOD_CALL_EXCEPTION);
    }
}
