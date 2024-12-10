package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    private String customDelimiter = "";

    public Delimiter(String rawInputValue) {
        this.customDelimiter = extractCustomDelimiter(rawInputValue);
        if (hasCustomDelimiter()) {
            validateCustomDelimiter(this.customDelimiter);
        }
    }

    private void validateCustomDelimiter(String customDelimiter) {
        validateIsLetter(customDelimiter);
        validateLength(customDelimiter);
        validateNotDefault(customDelimiter);
    }

    private void validateIsLetter(String customDelimiter) {
        if (customDelimiter.matches("\\d")) {
            throw new IllegalArgumentException("커스텀 구분자는 문자만 입력 가능합니다.");
        }
    }

    private void validateLength(String customDelimiter) {
        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 자만 입력 가능합니다.");
        }
    }

    private void validateNotDefault(String customDelimiter) {
        if (",:".contains(customDelimiter)) {
            throw new IllegalArgumentException("커스텀 구분자로 기본 구분자를 입력할 수 없습니다.");
        }
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
