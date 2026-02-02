package org.howard.edu.lsp.assignment2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class ETLPipeline {
    public static void main(String[] args) throws IOException{
        List<String> doc = null;
        try {
            doc = splitByLines("data/products.csv");
        } catch (NoSuchFileException e) {
            System.out.println("An error occurred. File not found");
            // e.printStackTrace(); wasnt sure if the stack trace counted as a clean exit so i omitted it
            System.exit(1);
        }

        if (doc.isEmpty()) {
            System.out.println("File is empty. Incorrect input");
            System.exit(1);
        }

        List<String> fields = new ArrayList<>();
        int size;
        float price;

        List<String> result = new ArrayList<>();
        
        //skip lines
        for (String line : doc) {
            fields = getFields(line);
            size = fields.size();
            
            if (line.equals("ProductID,Name,Price,Category")) {
                result.add("ProductID,Name,Price,Category,PriceRange");
                continue;
            }

            if (line.isEmpty() || size != 4 || !isNumeric(fields.get(2).strip()) || !isInt(fields.get(0))) {
                continue;
            }
            
            fields.set(1, fields.get(1).toUpperCase()); //Convert all product names to UPPERCASE.

            price = Float.parseFloat(fields.get(2)); // Convert string to float

            if (fields.get(3).equals("Electronics")) {
                price = (float) (price * 0.9); //If the category is "Electronics", apply a 10% discount to the price.
            }

            String formattedPrice = roundToTwo(price);
            fields.set(2, formattedPrice);
            price = Float.parseFloat(formattedPrice); // Use rounded value for comparisons

            if (fields.get(3).equals("Electronics") && price > 500) {
                fields.set(3, "Premium Electronics"); // change the category to "Premium Electronics"
            }

            fields.add(getPriceRange(price));
            fields.replaceAll(String::strip);
            result.add(String.join(",", fields));
    
        }
        
        writeOutput(result);

    }

    private static String getPriceRange(float price) {
        if (price <= 10) {
            return "Low";
        } else if (price > 10 && price <= 100) {
            return "Medium";
        } else if (price > 100 && price <= 500) {
            return "High";
        } else {
            return "Premium";
        }
    }

    private static String roundToTwo(float n) {
        BigDecimal bd = new BigDecimal(Float.toString(n));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toPlainString();
    }

    private static List<String> splitByLines(String fileName) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines;
               
    }

    private static List<String> getFields(String s) {
        List<String> arr = new ArrayList<>(Arrays.asList(s.split(",")));
        return arr;
    }

    private static boolean isNumeric(String s) {
        if (s == null) { 
            return false;
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private static boolean isInt(String s) {
        try {
            // checking valid integer using parseInt()
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }


    private static void writeOutput(List<String> data) {        
        Path file = Paths.get("data/transformed_products.csv");

        try {
            Files.write(file, data);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
