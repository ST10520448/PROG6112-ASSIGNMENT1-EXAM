/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreport;

/**
 * Responsible for printing the sales report
 */
public class PrintProduct {

    public void printTotalProductSales(int total) {
        System.out.println("TOTAL PRODUCT SALES: " + total);
    }

    public void printAverageProductSales(double average) {
        System.out.println("AVERAGE PRODUCT SALES: " + (int) average);
    }

    public void printMostPopularProduct(String mostPopular) {
        System.out.println("MOST POPULAR PRODUCT: " + mostPopular);
    }

    public void printReportHeader() {
        System.out.println("****************************************");
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("****************************************");
    }

    public void printReportFooter() {
        System.out.println("****************************************");
    }
}