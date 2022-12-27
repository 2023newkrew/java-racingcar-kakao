package racing.model;

public class Car {
    private String name;
    private Integer position;

    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    Integer getPosition() {
        return this.position;
    }

    void setPosition(Integer posiition) {
        this.position = posiition;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Car){
            Car other = (Car) obj;
            return this.name.equals(other.name);
        }
        return false;
    }
}
