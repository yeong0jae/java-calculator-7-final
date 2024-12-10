package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    private String customDelimiter = "";

    public Delimiter(String rawInputValue) {
        this.customDelimiter = extractCustomDelimiter(rawInputValue);
    }

    public List<Integer> separate(String rawInputValue) {
        String[] splitInput;
        if (hasCustomDelimiter()) {
            splitInput = rawInputValue.substring(5).split(customDelimiter);
            return convertTo(splitInput);
        }
        splitInput = rawInputValue.split("[" + COMMA + COLON + "]");
        return convertTo(splitInput);
    }

    private String extractCustomDelimiter(String rawInputValue) {
        if (rawInputValue.startsWith("//")) {
            if (rawInputValue.startsWith("\\n", 3)) {
                return String.valueOf(rawInputValue.charAt(2));
            }
        }
        return "";
    }

    private boolean hasCustomDelimiter() {
        return !customDelimiter.isEmpty();
    }

    private List<Integer> convertTo(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .toList();
    }
}
