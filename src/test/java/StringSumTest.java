import org.junit.jupiter.api.BeforeEach;
public class StringSumTest {

    private StringSum stringSum;
    private StringSum customStringSum;
    private String[] testList;

    @BeforeEach
    void setUp() {
        customStringSum = new StringSum("//;\n1;2;3");
        stringSum = new StringSum("1:2,3");

        testList = new String[] {"1", "2", "3"};
    }

}
