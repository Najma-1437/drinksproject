package com.managementstore.managementdrinks.model;
import java.util.HashMap;
import java.util.Map;

public class Branch {
    private final String location;
    private final Map<Drink, Integer> stock; // Drink -> Quantity
    private double totalSales;

    public Branch(String location) {
        this.location = location;
        this.stock = new HashMap<>();
    }

    // Method for adding stock
    public void addStock(Drink drink, int quantity) {
        stock.put(drink, stock.getOrDefault(drink, 0) + quantity);
    }

    public void recordSale(Drink drink) {
        int currentStock = stock.getOrDefault(drink, 0);
        if (currentStock > 0) {
            stock.put(drink, currentStock - 1);
            totalSales += drink.getBasePrice(); // Use Drink's price
        }
    }

    // Getters (unchanged)
    public String getLocation() { return location; }
    public double getTotalSales() { return totalSales; }
    public int getStock(Drink drink) { return stock.getOrDefault(drink, 0); }
}