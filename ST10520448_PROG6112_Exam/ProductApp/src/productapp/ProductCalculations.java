/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

public class ProductCalculations implements IProductCalculations {

    private double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * 0.15;          //It is for the 15% VAT
    }

    @Override
    public double GetCommission() {
        return price * 0.05;          // Used for the 5% Commission
    }

    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}
