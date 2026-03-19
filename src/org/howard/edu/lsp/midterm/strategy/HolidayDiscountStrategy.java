package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for holiday customers — applies a 15% discount.
 *
 * @author Howard Student
 */
public class HolidayDiscountStrategy implements DiscountStrategy {

    /**
     * Returns the price after a 15% holiday discount.
     *
     * @param price the original price
     * @return price multiplied by 0.85
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}
