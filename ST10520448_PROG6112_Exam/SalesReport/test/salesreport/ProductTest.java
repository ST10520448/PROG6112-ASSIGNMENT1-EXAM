package salesreport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    // Sample data from the exam paper
    private final String[] names = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    private final int[][] sales = {
        {25, 18, 20},   // Cozy Nights Monarch = 63
        {15, 10, 12},   // Restonic Barbados   = 37
        {18, 15, 20}    // Sealy Phuket         = 53
    };

    // Unit Test 1 – GetTotalProductsSold
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        int expected = 153;          // 63 + 37 + 53
        int actual = product.GetTotalProductsSold();
        assertEquals(expected, actual);
    }

    // Unit Test 2 – GetAverageProductSold
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        double expected = 51.0;      // 153 ÷ 3
        double actual = product.GetAverageProductSold();
        assertEquals(expected, actual, 0.001);
    }
}