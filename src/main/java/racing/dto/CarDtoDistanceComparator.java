package racing.dto;

import java.util.Comparator;

public class CarDtoDistanceComparator implements Comparator<CarDTO> {
    @Override
    public int compare(CarDTO o1, CarDTO o2) {
        return Integer.compare(o1.getDistance(), o2.getDistance());
    }
}
