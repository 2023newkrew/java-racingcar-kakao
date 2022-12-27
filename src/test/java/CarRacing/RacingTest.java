package CarRacing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    //자동차 이름 스플릿 로직 작성
    //자동차 이름 예외처리 로직 작성
    //자동차 객체 배열 생성
    //시도 회수 입력 받기
    //자동차들 각각에 전진 이벤트 부여 메소드 작성
    //시도 회수만큼 이벤트 발생하는 메소드 작성
    //출력 메소드 작성
    //우승자 판별 로직 작성

    @Test
    public void nameSplitTest() {
        String inputString = "pobi,crong,honux";
        Racing racing = new Racing();
        assertThat(racing.nameSplit(inputString)).isEqualTo(new String[] {"pobi", "crong", "honux"});
    }

}
