package org.howard.edu.lsp.midterm.strategy;

/**
 * Discount strategy for member customers — applies a 10% discount.
 *
 * @author Howard Student
 */
public class MemberDiscountStrategy implements DiscountStrategy {

    /**
     * Returns the price after a 10% member discount.
     *
     * @param price the original price
     * @return price multiplied by 0.90
     */
    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}
