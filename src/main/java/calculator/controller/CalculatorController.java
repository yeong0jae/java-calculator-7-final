package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.view.InputView;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String rawInputValue = inputView.readInputValue();

        Delimiter delimiter = new Delimiter();
        List<Integer> inputNumbers = delimiter.separate(rawInputValue);

        Calculator calculator = new Calculator();
        calculator.sum(inputNumbers);
    }

}
