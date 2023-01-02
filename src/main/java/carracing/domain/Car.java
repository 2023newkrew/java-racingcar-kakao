package carracing.domain;

public class Car{
    private final String name;
    private Integer position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        this.name = name;
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

    public String getName() {
        return this.name;
    }
}
