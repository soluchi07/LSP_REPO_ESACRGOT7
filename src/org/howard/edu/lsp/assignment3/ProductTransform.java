package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Handles the Transform phase of the ETL pipeline.
 * Applies all business rules to a list of {@link Product} objects in place.
 */
public class ProductTransform {

    /**
     * Transforms a list of Product objects by applying the following rules in order:
     * <ul>
     *   <li>Converts the product name to uppercase.</li>
     *   <li>Applies a 10% discount to products in the "Electronics" category.</li>
     *   <li>Rounds the price to two decimal places.</li>
     *   <li>Upgrades "Electronics" products with a price above $500 to "Premium Electronics".</li>
     *   <li>Assigns a price range label: Low (&le;$10), Medium ($10&ndash;$100),
     *       High ($100&ndash;$500), or Premium (&gt;$500).</li>
     * </ul>
     *
     * @param products the list of products to transform
     * @return the same list with all transformations applied
     */
    public List<Product> transform(List<Product> products) {
        for (Product p : products) {
            // Normalize name to uppercase for consistent output formatting
            p.setName(p.getName().toUpperCase());

            double price = p.getPrice();

            // Electronics products receive a 10% promotional discount
            if (p.getCategory().equals("Electronics")) {
                price *= 0.9;
            }

            // Round to 2 decimal places before comparisons to avoid floating-point drift
            price = roundToTwo(price);
            p.setPrice(price);

            // Electronics items priced above $500 after discount are reclassified as premium
            if (p.getCategory().equals("Electronics") && price > 500) {
                p.setCategory("Premium Electronics");
            }

            // Assign a human-readable price range label based on the final rounded price
            p.setPriceRange(getPriceRange(price));
        }

        return products;
    }

    /**
     * Rounds a price to two decimal places using HALF_UP rounding.
     * Parses back from the formatted string to avoid floating-point drift.
     *
     * @param price the price to round
     * @return the price rounded to two decimal places
     */
    private double roundToTwo(double price) {
        BigDecimal bd = new BigDecimal(Double.toString(price));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return Double.parseDouble(bd.toPlainString());
    }

    /**
     * Returns the price range label for a given price.
     *
     * @param price the price to classify
     * @return "Low" if &le;$10, "Medium" if $10&ndash;$100,
     *         "High" if $100&ndash;$500, or "Premium" if &gt;$500
     */
    private String getPriceRange(double price) {
        if (price <= 10) {
            return "Low";
        } else if (price <= 100) {
            return "Medium";
        } else if (price <= 500) {
            return "High";
        } else {
            return "Premium";
        }
    }
}
