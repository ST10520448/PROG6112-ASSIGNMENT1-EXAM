/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreport;

import java.util.Scanner;

public class SalesReportApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Single-dimensional array displaying product names
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array – sales [3 products][3 months]
        int[][] salesData = new int[3][3];

        // ===== Capture sales data from user =====
        System.out.println("Enter sales figures for the three products over three months:\n");

        for (int i = 0; i < productNames.length; i++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month " + (month + 1)
                        + " for " + productNames[i] + " mattress: ");
                salesData[i][month] = scanner.nextInt();
            }
            System.out.println();
        }

        // Create Product object
        Product product = new Product(productNames, salesData);

        // Create PrintProduct object
        PrintProduct printer = new PrintProduct();

        // ===== Display the report =====
        System.out.println();
        printer.printReportHeader();
        printer.printTotalProductSales(product.GetTotalProductsSold());
        printer.printAverageProductSales(product.GetAverageProductSold());
        printer.printMostPopularProduct(product.GetMostPopularProduct());
        printer.printReportFooter();

        scanner.close();
    }
}