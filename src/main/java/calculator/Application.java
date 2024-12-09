package calculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Integer> inputNumbers = List.of(1, 2, 3);

        Calculator calculator = new Calculator();
        calculator.sum(inputNumbers);

    }
    
}
