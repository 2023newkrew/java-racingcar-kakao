package racing.dto;

import java.util.Comparator;

public class CarDtoDistanceComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof CarDTO) || !(o2 instanceof CarDTO)) {
            throw new IllegalArgumentException("[ERROR] 인자 타입을 확인해주세요.");
        }
        return ((CarDTO) o1).getDistance() - ((CarDTO) o2).getDistance();
    }
}
