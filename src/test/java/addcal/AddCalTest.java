package addcal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCalTest {

    @Test
    void ParseTest() { //숫자 리스트를 만드는 함수를 테스트한다,
        String inputString = "123,45";
        AddCal addCal = new AddCal(inputString);
        List<CalNum> calNumList = addCal.calNumList;
        List<CalNum> tmp = new ArrayList();
        tmp.add(new CalNum(123));
        tmp.add(new CalNum(45));
        assertThat(calNumList).usingRecursiveComparison().isEqualTo(tmp);
    }
<<<<<<< HEAD

    @Test
    void customSeparatorTest() {
=======
    @Test
    void customSeparatorTest(){
>>>>>>> cfa8a91 (feat: Car)
        String inputString = "//a\n1a2a3";
        AddCal addCal = new AddCal(inputString);
        String separator = addCal.separator;
        assertEquals(separator, "a");
    }

}
