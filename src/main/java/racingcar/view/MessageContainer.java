package racingcar.view;

import java.util.HashMap;
import java.util.Map;

public class MessageContainer {
    private final Map<Integer, String> messages;
    private final int DEFAULT_CODE = -1;
    private final String defaultMessage;
    public MessageContainer(String[] messages, String defaultMessage){
        Map<Integer, String> mapMessage = new HashMap<>();
        for (int i=1;i<=messages.length;i++){
            mapMessage.put(i, messages[i-1]);
        }
        this.messages = mapMessage;
        this.defaultMessage = defaultMessage;
    }
    public MessageContainer(Map<Integer, String> messages, String defaultMessage){
        if (messages.containsKey(DEFAULT_CODE)){
            throw new RuntimeException("code -1 is nor permitted for inner logic.");
        }
        this.messages = messages;
        this.defaultMessage = defaultMessage;
    }

    public String getMessage(int code){
        if (messages.containsKey(code)){
            return messages.get(code);
        }
        return defaultMessage;
    }
}
