package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private final String COMMA = ",";
    private final String COLON = ":";
    private String customDelimiter = "";

    public Delimiter(String rawInputValue) {
        this.customDelimiter = extractCustomDelimiter(rawInputValue);
    }

    private String extractCustomDelimiter(String rawInputValue) {
        if (rawInputValue.startsWith("//")) {
            if (rawInputValue.charAt(3) == '\n') {
                return String.valueOf(rawInputValue.charAt(3));
            }
        }
        return "";
    }

    public List<Integer> separate(String rawInputValue) {
        String[] splitInput;
        if (customDelimiter.isEmpty()) {
            splitInput = rawInputValue.split("[" + COMMA + COLON + "]");
            return convertTo(splitInput);
        }
        splitInput = rawInputValue.split(customDelimiter);
        return convertTo(splitInput);
    }

    private List<Integer> convertTo(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .toList();
    }
}
