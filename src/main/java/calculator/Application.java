package calculator;

import calculator.view.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        String rawInputValue = inputView.readInputValue();

        List<Integer> inputNumbers = List.of(1, 2, 3);

        Calculator calculator = new Calculator();
        calculator.sum(inputNumbers);

    }

}
