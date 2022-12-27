package racingcar;

import java.util.Scanner;

public class View {
    Racing racing = new Racing();
    public void Input() {
        Scanner sc = new Scanner(System.in);
        String carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = sc.nextLine();
        } while (!racing.RegisterCarNames(carNames));

        String roundNum;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            roundNum = sc.nextLine();
        } while (!racing.RegisterCarRoundNum(roundNum));
    }
    public void RunRound(){
        for (int i = 0  ; i < racing.GetRoundNum() ; i++) {
            racing.Round();
            String result = racing.RoundResult();
            PrintRoundResult(result);
        }
    }
    public void PrintRoundResult(String result) {
        String[] temp = result.split(",");
        for(int i = 0 ; i < temp.length ; i+=2){
            System.out.print(temp[i] +" : ");
            System.out.println("-".repeat(Integer.parseInt(temp[i+1])));
        }
        System.out.println();
    }

    public void PrintWinner(){
        System.out.print(String.join(", ", racing.GetWinner()));
        System.out.println("가 최종 우승했습니다.");
    }


}
