package addcal;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        AddCal addCal;
        while (true) {
            try {
                addCal = new AddCal(cal.getCalculatorInput());
                cal.printCalculatorOutput(addCal);
                break;
            } catch (Exception E) {
                System.out.println(E);
            }
        }
    }
}
