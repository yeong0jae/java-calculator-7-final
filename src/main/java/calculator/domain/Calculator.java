package calculator.domain;

import java.util.List;

public class Calculator {

    private final List<Integer> operands;

    public Calculator(List<Integer> operands) {
        this.operands = operands;
    }

    public int sum() {
        return this.operands.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
