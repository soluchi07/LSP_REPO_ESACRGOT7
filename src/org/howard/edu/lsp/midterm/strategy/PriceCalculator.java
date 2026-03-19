package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates a final price by delegating to a DiscountStrategy.
 * The strategy can be set at runtime to change discount behavior.
 *
 * @author Howard Student
 */
public class PriceCalculator {

    private DiscountStrategy strategy;

    /**
     * Constructs a PriceCalculator with the given discount strategy.
     *
     * @param strategy the discount strategy to apply
     */
    public PriceCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets a new discount strategy.
     *
     * @param strategy the new strategy to use
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price by applying the current discount strategy.
     *
     * @param price the original price
     * @return the discounted final price
     */
    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}
