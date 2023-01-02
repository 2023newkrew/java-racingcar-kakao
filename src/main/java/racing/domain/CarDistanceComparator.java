package racing.domain;

import java.util.Comparator;

public class CarDistanceComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPosition().compareTo(o2.getPosition());
    }
}
