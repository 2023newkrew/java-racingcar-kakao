package carracing.domain;

public class Car implements RacingPlayer {
    private final String name;
    private Integer position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void proceedNextTurn(Boolean proceed) {
        if (proceed) {
            this.position += 1;
        }
    }

    @Override
    public Integer getPosition() {
        return this.position;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
