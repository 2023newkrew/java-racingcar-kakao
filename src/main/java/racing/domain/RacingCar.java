package racing.domain;


public class RacingCar implements Car {

    private final Name name;
    private int position;
    private static final int DEFAULT_POSITION = 0;

    public RacingCar(String name) {
        this(name, DEFAULT_POSITION);
    }

    public RacingCar(String name, int position) {
        this.name = new Name(name.trim());
        this.position = position;
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
        this.position++;
    }

}