package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    List<Car> cars = new ArrayList<>();
    int roundNum;
    public boolean RegisterCarNames(String input) {
        String[] temp = input.split(",");
        for (String name : temp) {
            if(name.length() > 5)
                return false;
        }

        for (String name : temp){
            cars.add(new Car(name));
        }
        return true;
    }
    public boolean RegisterCarRoundNum(String input) {
        try{
            roundNum = Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }/*
    public List<String> Run() { /////컨트롤러에서 구현
        int i = 0;
        while(i < roundNum){
            Round();
            i++;
        }
        return GetWinner();
    }*/
    public boolean Round() {
        for (Car car : cars) {
            car.move(random());
        }
        return true;
    }

    public String RoundResult(){
        String temp="";
        for (Car car : cars) {
            temp += car.getName()+","+car.getPosition()+",";
        }
        return temp;
    }
    private boolean random() {
        Random rand = new Random();
        return rand.nextInt(10) >= 4;
    }

    public List<String> GetWinner(){
        int maxPosition = 0;
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars){
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars){
            if(car.getPosition() == maxPosition){
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public int GetRoundNum(){
        return roundNum;
    }
}
