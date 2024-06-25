package calc.Validators;

import java.io.File;

public abstract class ArgumentValidator {

    public static boolean isValidCsvPath(String path) {
        File file = new File(path);
        return file.exists() && file.isFile() && path.endsWith(".csv");
    }

    public static boolean isValidOperationSymbol(String symbol) {
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/");
    }

    public static boolean validateArguments(String[] args) {
        if (args.length != 2) {
            return false;
        }

        String csvPath = args[0];
        String operationSymbol = args[1];


        return isValidCsvPath(csvPath) && isValidOperationSymbol(operationSymbol);
    }

}
