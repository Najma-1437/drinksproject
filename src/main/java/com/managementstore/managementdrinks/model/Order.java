package com.managementstore.managementdrinks.model;

import java.time.LocalDateTime;

public class Order {
    private String orderId;
    private String customerId;
    private String drinkType;
    private int quantity;
    private String branchName;
    private LocalDateTime timestamp;
    private double totalPrice;

    public Order(String orderId, String customerId, String drinkType, int quantity, String branchName, double unitPrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.drinkType = drinkType;
        this.quantity = quantity;
        this.branchName = branchName;
        this.timestamp = LocalDateTime.now();
        this.totalPrice = calculateTotal(unitPrice);
    }

    private double calculateTotal(double unitPrice) {
        return quantity * unitPrice;
    }

    public String getOrderSummary() {
        return "Order #" + orderId + " by Customer " + customerId + " | " + drinkType + " x" + quantity +
                " @ " + branchName + " on " + timestamp + " | Total: Ksh" + totalPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Object getOrderId() {
        return orderId;
    }
    public  String getDrinkType(){
        return drinkType;
    }
}