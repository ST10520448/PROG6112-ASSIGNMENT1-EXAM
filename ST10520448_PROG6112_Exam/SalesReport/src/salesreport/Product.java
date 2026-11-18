/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreport;

/**
 * Product class that stores sales data using arrays
 * and calculates total, average and most popular product.
 */
public class Product implements IProduct {

    // Single-dimensional array for product names
    private String[] productNames;

    // Two-dimensional array for sales [product][month]
    private int[][] salesData;

    // Constructor
    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    /**
     * Calculates the total number of products sold across all products and months
     */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }

    /**
     * Calculates the average number of products sold per product
     * (total sales ÷ number of products)
     */
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        return (double) total / productNames.length;
    }

    /**
     * Determines the most popular product based on highest total sales
     */
    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        String mostPopular = "";

        for (int i = 0; i < productNames.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                productTotal += salesData[i][j];
            }

            if (productTotal > maxSales) {
                maxSales = productTotal;
                mostPopular = productNames[i] + " (" + productTotal + ")";
            }
        }
        return mostPopular;
    }
}