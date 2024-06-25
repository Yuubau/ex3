package calc.Printer;

import java.util.List;

public abstract class OperationPrinter {

    public static void renderOperation(List<Integer> values, int result, String operation) {
        StringBuilder output = new StringBuilder();
        int intermediateResult = values.get(0);
        output.append(intermediateResult).append("\n");

        for (int i = 1; i < values.size(); i++) {
            int value = values.get(i);
            switch (operation) {
                case "+" -> intermediateResult += value;
                case "-" -> intermediateResult -= value;
                case "*" -> intermediateResult *= value;
                case "/" -> {
                    if (value != 0) {
                        intermediateResult /= value;
                    } else {
                        output.append("Error: Division by zero\n");
                        return;
                    }
                }
                default -> {
                    output.append("Unknown operation\n");
                    return;
                }
            }
            output.append(operation).append(value).append(" (= ").append(intermediateResult).append(")\n");
        }

        output.append("-------\n");
        output.append("total = ").append(result).append(" (").append(getOperationName(operation)).append(")\n");
        System.out.println(output.toString());
    }

    private static String getOperationName(String operation) {
        return switch (operation) {
            case "+" -> "addition";
            case "-" -> "subtraction";
            case "*" -> "multiplication";
            case "/" -> "division";
            default -> "unknown operation";
        };
    }
}