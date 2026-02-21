package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 * Entry point for the ETL pipeline.
 * Orchestrates the Extract, Transform, and Load phases by delegating to
 * {@link CSVRead}, {@link ProductTransform}, and {@link CSVWrite}.
 */
public class ETLPipeline {

    /**
     * Runs the ETL pipeline. Reads product data from {@code data/products.csv},
     * applies all transformations, and writes the result to
     * {@code data/transformed_products.csv}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        CSVRead reader = new CSVRead();
        ProductTransform transformer = new ProductTransform();
        CSVWrite writer = new CSVWrite();

        List<Product> products;

        try {
            products = reader.read("data/products.csv");
        } catch (NoSuchFileException e) {
            System.out.println("An error occurred. File not found");
            System.exit(1);
            return;
        } catch (IllegalStateException e) {
            System.out.println("File is empty. Incorrect input");
            System.exit(1);
            return;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(1);
            return;
        }

        transformer.transform(products);
        writer.write(products, "data/transformed_products.csv");
        System.out.println("Successfully wrote to the file.");
    }
}
