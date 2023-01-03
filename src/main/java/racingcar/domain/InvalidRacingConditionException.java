package racingcar.domain;

public class InvalidRacingConditionException extends RuntimeException{
    public InvalidRacingConditionException(){
        super();
    }
    public InvalidRacingConditionException(String message){
        super(message);
    }
}
