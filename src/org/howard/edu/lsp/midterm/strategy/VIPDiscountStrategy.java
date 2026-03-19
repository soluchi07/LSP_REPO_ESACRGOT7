package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for VIP customers — applies a 20% discount.
 *
 * @author Howard Student
 */
public class VIPDiscountStrategy implements DiscountStrategy {

    /**
     * Returns the price after a 20% VIP discount.
     *
     * @param price the original price
     * @return price multiplied by 0.80
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
