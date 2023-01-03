package racingcar.view;

import racingcar.model.Car;
import racingcar.view.condition.InputParser;
import racingcar.view.exceptions.DuplicatedNameException;
import racingcar.view.exceptions.InvalidFormatException;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public Integer getNumberOfGames(){
        return enterTryCount();
    }

    public List<Car> askCarsInfo() {
        String carsName = enterCarsName();
        return registerCarsName(carsName);
    }

    public List<Car> registerCarsName(String carsName){
        List<Car> carList = parsingCarsName(carsName);
        return validateCarList(carList);
    }

    private List<Car> validateCarList(List<Car> carList){
        if (carList.size() <= 1) {
            throw new InvalidFormatException("경주할 유효한 자동차가 없습니다. 각 자동차의 이름을 5자 이하로 2대 이상 작성해주세요.");
        }
        return carList;
    }

    private String enterCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private int enterTryCount() throws InvalidFormatException{
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidFormatException("정확한 숫자가 입력되어야 합니다", e);
        }
    }

    private List<Car> parsingCarsName(String carsName){
        InputParser inputParser = new InputParser();
        List<String> splitCarsName = inputParser.splitNames(carsName);
        if(splitCarsName.size() != splitCarsName.stream().distinct().count()){
            throw new DuplicatedNameException("중복된 자동차 이름이 존재합니다");
        }
        return splitCarsName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
