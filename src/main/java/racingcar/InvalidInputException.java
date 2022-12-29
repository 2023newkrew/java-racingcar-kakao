package racingcar;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(){}
    public InvalidInputException(String s){
        super(s);
    }
}
