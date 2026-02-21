package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Handles the Extract phase of the ETL pipeline.
 * Reads a CSV file and parses valid rows into {@link Product} objects.
 * Rows that are empty, have the wrong number of fields, a non-integer
 * ProductID, or a non-numeric Price are silently skipped.
 */
public class CSVRead {

    private static final String HEADER = "ProductID,Name,Price,Category";

    /**
     * Reads the CSV file at the given path and returns a list of valid
     * {@link Product} objects. The header row is skipped automatically.
     * Throws {@link IllegalStateException} if the file contains no lines at all.
     *
     * @param filePath the path to the input CSV file
     * @return a list of valid Product objects parsed from the file
     * @throws IOException           if the file cannot be read
     * @throws IllegalStateException if the file is completely empty
     */
    public List<Product> read(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        if (lines.isEmpty()) {
            throw new IllegalStateException("File is empty");
        }

        List<Product> products = new ArrayList<>();

        for (String line : lines) {
            if (line.isEmpty()) continue;
            if (line.equals(HEADER)) continue;

            List<String> fields = new ArrayList<>(Arrays.asList(line.split(",")));

            if (fields.size() != 4) continue;
            if (!isInt(fields.get(0).strip())) continue;
            if (!isNumeric(fields.get(2).strip())) continue;

            int productId = Integer.parseInt(fields.get(0).strip());
            String name = fields.get(1).strip();
            double price = Double.parseDouble(fields.get(2).strip());
            String category = fields.get(3).strip();

            products.add(new Product(productId, name, price, category));
        }

        return products;
    }

    /**
     * Returns true if the given string can be parsed as an integer.
     *
     * @param s the string to check
     * @return true if s is a valid integer, false otherwise
     */
    private boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Returns true if the given string can be parsed as a number.
     *
     * @param s the string to check
     * @return true if s is a valid number, false otherwise
     */
    private boolean isNumeric(String s) {
        if (s == null) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
