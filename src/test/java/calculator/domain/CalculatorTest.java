package calculator.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    @Test
    @DisplayName("구분된 숫자의 합을 계산한다.")
    void sumTest() {
        List<Integer> numbers = List.of(1, 2, 3);
        Calculator calculator = new Calculator(numbers);

        int sum = calculator.sum();

        Assertions.assertThat(sum).isEqualTo(6);
    }

    @DisplayName("계산기의 숫자가 양수가 아니라면 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("provideNumberList")
    void validatePositiveTest(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new Calculator(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> provideNumberList() {
        return Stream.of(
                List.of(-1, 2, 3),
                List.of(0, 2, 3)
        );
    }
}
