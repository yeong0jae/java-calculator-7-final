package calculator.domain;

import java.util.List;

public class Calculator {

    private final List<Integer> operands;

    public Calculator(List<Integer> operands) {
        validatePositive(operands);
        this.operands = operands;
    }

    private void validatePositive(List<Integer> operands) {
        operands.forEach(operand -> {
            if (operand <= 0) {
                throw new IllegalArgumentException("0 이하의 수는 입력할 수 없습니다.");
            }
        });
    }

    public int sum() {
        return this.operands.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
