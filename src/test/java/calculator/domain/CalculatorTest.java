package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("구분된 숫자의 합을 계산한다.")
    void sumTest() {
        List<Integer> numbers = List.of(1, 2, 3);
        Calculator calculator = new Calculator();

        int sum = calculator.sum(numbers);

        Assertions.assertThat(sum).isEqualTo(6);
    }
}
