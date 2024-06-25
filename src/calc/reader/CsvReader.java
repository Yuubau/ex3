package calc.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class CsvReader {

    // Méthode pour vérifier si une ligne contient des chiffres
    private static boolean containsDigit(String line) {
        return Pattern.compile("[0-9]").matcher(line).find();
    }

    // Méthode pour lire un fichier CSV et retourner les lignes contenant des chiffres
    public static List<Integer> readCsvLinesWithDigits(String csvFilePath) {
        List<Integer> linesWithDigits = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (containsDigit(line)) {
                    linesWithDigits.add(Integer.parseInt(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesWithDigits;
    }
}