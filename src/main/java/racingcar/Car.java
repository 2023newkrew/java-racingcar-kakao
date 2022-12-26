package racingcar;

public class Car {
    private final String name;
    private int position = 1;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 1);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveWithPower(int power) {
        if (power > 3) {
            this.position++;
        }
    }

    public String getCurrentStatus() {
        return this.name + " : "
                + "-".repeat(Math.max(0, this.position));
    }

//    public int renewWinners(int max, List<String> result) {
//        if (position < max) {
//            return max;
//        }
//        if (position > max) {
//            result.clear();
//        }
//        result.add(name);
//        return position;
//    }
}
