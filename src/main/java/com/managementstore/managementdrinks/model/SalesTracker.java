package com.managementstore.managementdrinks.model;
import java.util.*;
// SalesTracker class to manage sales data
public class SalesTracker {
    private final Map<Drink, Double> drinkSales; // Drink -> total revenue

    public SalesTracker() {
        this.drinkSales = new HashMap<>();
    }

    // Record a sale
    public void recordSale(Drink drink) {
        drinkSales.put(drink, drinkSales.getOrDefault(drink, 0.0) + drink.getBasePrice());
    }

    // Generate sales report
    public void generateSalesReport() {
        System.out.println("==== DRINK SALES REPORT ====");
        for (Map.Entry<Drink, Double> entry : drinkSales.entrySet()) {
            System.out.printf("%s: Ksh %.2f\n",entry.getKey().getName(), entry.getValue());

        }
    }
}