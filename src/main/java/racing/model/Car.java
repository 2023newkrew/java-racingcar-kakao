package racing.model;

import java.util.Random;

public class Car implements Comparable<Car>{
    private final String name;
    private Integer position;
    private final Random random;

    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
        this.random = new Random();
    }

    public void tryMove() {
        if (random.nextInt(10) >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Car){
            Car other = (Car) obj;
            return this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public String toString(){
        return name + " : " + "-".repeat(Math.max(1, position));
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position, other.position);
    }
}
