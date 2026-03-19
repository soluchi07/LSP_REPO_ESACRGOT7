package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern implementation for price calculation.
 *
 * @author Howard Student
 */
public class Driver {

    /**
     * Entry point. Runs each discount strategy with a base price of 100.0.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        double basePrice = 100.0;

        PriceCalculator calculator = new PriceCalculator(new RegularDiscountStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new MemberDiscountStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new VIPDiscountStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new HolidayDiscountStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(basePrice));
    }
}
