package racingcar.view;

import racingcar.domain.InvalidInputException;
import racingcar.domain.InvalidRacingConditionException;

import java.io.PrintStream;
import java.util.Arrays;

public class ExceptionViewKorean implements ExceptionView {

    private enum ExceptionMatcher{
        INVALID_INPUT_EXCEPTION(InvalidInputException.class, new MessageContainer(
                new String[]{"이름의 길이는 1 이상 5 이하여야 합니다.",
                "차는 두 대 이상이어야 합니다.",
                "차의 이름은 중복될 수 없습니다.",
                "시도 횟수는 양의 정수여야 합니다."},
                "입력 관련 오류가 발생했습니다.")
        ),

        INVALID_RACING_CONDITION_EXCEPTION(InvalidRacingConditionException.class, new MessageContainer(
           new String[]{
                   "이미 경기가 끝났습니다.",
                   "경기가 아직 끝나지 않았습니다.",
                   "라운드 횟수는 1 이상이어야 합니다.",
                   "경기에 참여하는 차의 개수는 2개 이상이어야 합니다.",
                   "중복된 차가 있습니다."},
                "경기 진행 관련 오류가 발생했습니다."

        )),
        NUMBER_FORMAT_EXCEPTION(NumberFormatException.class, new MessageContainer(
                new String[]{},
                "올바른 형식으로 입력하세요."
        ));

        private Class<? extends Exception> classType;
        private MessageContainer messageContainer;

        ExceptionMatcher(Class<? extends Exception> classType, MessageContainer messageContainer) {
            this.classType = classType;
            this.messageContainer = messageContainer;
        }

        public MessageContainer getMessageContainerIfMatch(Exception e){
            if (e!=null && e.getClass() == this.classType){
                return this.messageContainer;
            }
            return null;
        }
    }
    private final static MessageContainer DEFAULT_MESSAGE_CONTAINER = new MessageContainer(
            new String[]{},
            "알 수 없는 오류가 발생했습니다."
    );
    private final static int DEFAULT_CODE = -1;
    private final PrintStream errorStream;

    public ExceptionViewKorean(PrintStream errorStream){
        this.errorStream = errorStream;
    }
    @Override
    public void errorHandling(Exception e) {
        MessageContainer messageContainer = getMessageContainer(e);
        int messageCode = getMessageCode(e);
        errorStream.println(messageContainer.getMessage(messageCode));
    }
    private MessageContainer getMessageContainer(Exception e){
        MessageContainer messageContainer[] = Arrays.stream(ExceptionMatcher.values())
                .filter(v->v.getMessageContainerIfMatch(e)!=null)
                .map(v->v.messageContainer)
                .toArray(MessageContainer[]::new);
        if (messageContainer.length == 0){
            return DEFAULT_MESSAGE_CONTAINER;
        }
        return messageContainer[0];
    }
    private int getMessageCode(Exception e){
        int index;
        try {
            index = Integer.parseInt(e.getMessage().split("\\:")[0].strip());
        } catch(Exception exception){
            index = DEFAULT_CODE;
        }
        return index;
    }
}
