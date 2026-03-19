package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for computing a discounted price.
 *
 * @author Howard Student
 */
public interface DiscountStrategy {

    /**
     * Applies the discount to the given price and returns the final price.
     *
     * @param price the original price before discount
     * @return the price after the discount is applied
     */
    double applyDiscount(double price);
}
