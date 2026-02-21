package org.howard.edu.lsp.assignment3;

/**
 * Represents a single product record from the CSV data.
 * Encapsulates the fields: productId, name, price, category, and priceRange.
 */
public class Product {

    private int productId;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    /**
     * Constructs a Product with the given field values.
     *
     * @param productId the integer product ID
     * @param name      the product name
     * @param price     the product price
     * @param category  the product category
     */
    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Returns the product ID.
     *
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the price range label assigned during transformation.
     *
     * @return the price range label (Low, Medium, High, or Premium)
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the product name.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the product price.
     *
     * @param price the new product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the product category.
     *
     * @param category the new product category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the price range label.
     *
     * @param priceRange the price range label (Low, Medium, High, or Premium)
     */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
