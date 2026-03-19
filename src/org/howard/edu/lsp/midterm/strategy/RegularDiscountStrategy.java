package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for regular customers — no discount applied.
 *
 * @author Howard Student
 */
public class RegularDiscountStrategy implements DiscountStrategy {

    /**
     * Returns the price unchanged.
     *
     * @param price the original price
     * @return the original price with no discount
     */
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
