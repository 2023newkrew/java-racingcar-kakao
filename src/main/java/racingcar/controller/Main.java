package racingcar.controller;


import racingcar.domain.Racing;
import racingcar.view.*;

public class Main {
    static InputView inputView = new InputViewKorean(System.in, System.out);
    static PrintView printView = new PrintViewKorean(System.out);
    static ExceptionView exceptionView = new ExceptionViewKorean(System.err);
    static Racing racing;
    public static void main(String[] args) {
        try {
            input();
            race();
            endRace();
        }catch(Exception e){
            exceptionView.errorHandling(e);
        }
    }

    private static void input(){
        racing = new Racing.Builder().
                addCars(inputView.getNamesArray())
                .setRounds(inputView.getTrialCount())
                .build();
    }

    private static void race(){
        printView.printStart();
        printView.printCars(racing.getCars());
        while(racing.isNotEnd()){
            racing.proceedRound();
            printView.printCars(racing.getCars());
        }
    }

    private static void endRace(){
        printView.printWinners(racing.getWinners());
    }
}
