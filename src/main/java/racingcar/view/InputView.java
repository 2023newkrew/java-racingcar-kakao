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
        return inputTryCount();
    }

    public List<Car> inputData() {
        String inputInputParsers = inputInputParsers();
        return isInputParserDuplicated(inputInputParsers);
    }

    public List<Car> isInputParserDuplicated(String inputInputParsers){
        List<Car> carList = registerCars(inputInputParsers);
        if (carList.size() <= 1) {
            throw new InvalidFormatException("경주할 유효한 자동차가 없습니다. 각 자동차의 이름을 5자 이하로 2대 이상 작성해주세요.");
        }
        return carList;
    }

    private String inputInputParsers() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private int inputTryCount() throws InvalidFormatException{
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidFormatException("정확한 숫자가 입력되어야 합니다");
        }
    }

    private List<Car> registerCars(String inputParsers){
        InputParser inputParser = new InputParser();
        List<String> splitInputParsers = inputParser.splitNames(inputParsers);
        if(splitInputParsers.size() != splitInputParsers.stream().distinct().count()){
            throw new DuplicatedNameException("중복된 자동차 이름이 존재합니다");
        }
        return splitInputParsers.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
