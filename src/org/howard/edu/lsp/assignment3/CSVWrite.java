package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the Load phase of the ETL pipeline.
 * Writes a list of transformed {@link Product} objects to a CSV file.
 */
public class CSVWrite {

    private static final String HEADER = "ProductID,Name,Price,Category,PriceRange";

    /**
     * Writes the given list of products to the specified CSV file path.
     * Always writes the output header row first, followed by one row per product.
     * Prices are formatted to exactly two decimal places using
     * {@link BigDecimal#toPlainString()}.
     *
     * @param products the list of transformed products to write
     * @param filePath the path to the output CSV file
     */
    public void write(List<Product> products, String filePath) {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);

        for (Product p : products) {
            String row = p.getProductId()
                    + "," + p.getName()
                    + "," + formatPrice(p.getPrice())
                    + "," + p.getCategory()
                    + "," + p.getPriceRange();
            lines.add(row);
        }

        try {
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Formats a price as a string with exactly two decimal places.
     * Uses {@link BigDecimal#toPlainString()} to avoid scientific notation.
     *
     * @param price the price to format
     * @return the formatted price string (e.g., "23.00", "8.99")
     */
    private String formatPrice(double price) {
        BigDecimal bd = new BigDecimal(Double.toString(price));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toPlainString();
    }
}
