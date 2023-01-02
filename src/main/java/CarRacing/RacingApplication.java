package CarRacing;

public class RacingApplication {
    public static void main(String[] args) {
        while (true) {
            try {
                Controller.RacingGame();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }
}
