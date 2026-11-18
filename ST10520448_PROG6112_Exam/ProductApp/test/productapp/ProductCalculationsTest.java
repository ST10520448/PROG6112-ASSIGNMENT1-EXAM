/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package productapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    // Unit Test 1 – Calculations for VAT
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        double expected = 525.0;          // 3500 × 0.15
        double actual = calc.GetVat();
        assertEquals(expected, actual, 0.001);
    }

    // Unit Test 2 – Calculations to get the total
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        double expected = 4200.0;         // 3500 + 525 + 175
        double actual = calc.GetTotal();
        assertEquals(expected, actual, 0.001);
    }
}