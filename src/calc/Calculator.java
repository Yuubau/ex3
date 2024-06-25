package calc;

import calc.Printer.OperationPrinter;
import calc.Validators.ArgumentValidator;
import calc.operation.Additioner;
import calc.operation.Multiplier;
import calc.operation.Soustractor;
import calc.reader.CsvReader;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    private boolean isCommandValid(String[] args) {
        return ArgumentValidator.validateArguments(args);
    }

    public Integer doCalculate(String operationSymbol,List<Integer> numbersToCompute) {

        Integer result;
        switch (operationSymbol) {
            case "+" -> result = Additioner.compute(numbersToCompute);
            case "-" -> result = Soustractor.compute(numbersToCompute);
            case "*" -> result = Multiplier.compute(numbersToCompute);
            default -> result = null;
        }

        return result;
    }

    public void calculate(String[] args) {
        if(!isCommandValid(args)) {
            System.out.println("Invalid args");
            return;
        }

        String csvPath = args[0];
        String operationSymbol = args[1];
        List<Integer> numbersToCompute = CsvReader.readCsvLinesWithDigits(csvPath);

        Integer result = doCalculate(operationSymbol, numbersToCompute);

        OperationPrinter.renderOperation(numbersToCompute, result, operationSymbol);

    }






}
