package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String rawInputValue = inputView.readInputValue();

        Delimiter delimiter = new Delimiter(rawInputValue);
        List<Integer> inputNumbers = delimiter.separate(rawInputValue);

        Calculator calculator = new Calculator(inputNumbers);
        int sum = calculator.sum();

        outputView.printResult(sum);
    }

}
