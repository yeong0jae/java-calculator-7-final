package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private final String COMMA = ",";
    private final String COLON = ":";

    public List<Integer> separate(String rawInputValue) {
        String[] separatedInput = rawInputValue.split("[" + COMMA + COLON + "]");

        return Arrays.stream(separatedInput)
                .map(Integer::parseInt)
                .toList();
    }
}
