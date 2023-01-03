package racing.model;

import racing.util.RandomUtil;


public class Car implements Comparable<Car>{
    private final String name;
    private Integer position;
    
    private static final Integer MOVE_THRESHOLD = 4;
    private static final Integer UPPER_BOUND_OF_RANDOM = 10;
    private static final Integer INITIAL_POSITION = 1;

    public Car(String name){
        this(name, INITIAL_POSITION);
    }

    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public void tryMove() {
        if (RandomUtil.getRandomInteger(UPPER_BOUND_OF_RANDOM) >= MOVE_THRESHOLD) {
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
