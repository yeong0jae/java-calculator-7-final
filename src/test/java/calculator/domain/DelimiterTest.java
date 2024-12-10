package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    @DisplayName("문자열을 기본 구분자를 기준으로 구분한다.")
    void separateTest() {
        String rawInputValue = "1,2:3";
        Delimiter delimiter = new Delimiter(rawInputValue);

        List<Integer> separatedValue = delimiter.separate(rawInputValue);

        Assertions.assertThat(separatedValue).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("문자열을 커스텀 구분자를 기준으로 구분한다.")
    void separateByCustomTest() {
        String rawInputValue = "//;\\n1;2;3";
        Delimiter delimiter = new Delimiter(rawInputValue);

        List<Integer> separatedValue = delimiter.separate(rawInputValue);

        Assertions.assertThat(separatedValue).isEqualTo(List.of(1, 2, 3));
    }

}