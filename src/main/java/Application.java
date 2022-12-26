public class Application {
    public static void main(String[] args) {
        StringParser parser = new StringParser();
        CalculatorRunner runner = new CalculatorRunner(parser);

        runner.run();
    }
}
