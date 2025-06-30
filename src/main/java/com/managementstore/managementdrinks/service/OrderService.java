package com.managementstore.managementdrinks.service;

import com.managementstore.managementdrinks.manager.CustomerManager;
import com.managementstore.managementdrinks.model.Order;
import com.managementstore.managementdrinks.model.Customer;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {
    private final List<Order> orders;
    private final CustomerService customerService;
    private List<String> drinkType;

    public OrderService(CustomerService customerService) {
        this.orders = new ArrayList<>();
        this.customerService = customerService;
    }

    public void placeOrder(String orderId, String customerId, String drinkType, int quantity, String branchName) {

        Optional<Customer> customerOptional = customerService.getCustomerById(customerId);
        if (customerOptional.isEmpty()) {
            System.err.println("Error: Customer with ID '" + customerId + "' not found. Order cannot be placed.");
            return;
        }


        double unitPrice = getUnitPriceForDrink(drinkType);
        if (unitPrice <= 0) {
            System.err.println("Error: Invalid or unknown drink type '" + drinkType + "'. Cannot place order.");
            return;
        }

        try {
            Order order = new Order(orderId,customerId, drinkType, quantity, branchName, unitPrice);
            orders.add(order);
            System.out.println("Order placed: " + order.getOrderSummary());
            CustomerManager.linkOrderToCustomer(customerId, orderId);
        } catch (IllegalArgumentException e) {
            System.err.println("Error placing order: " + e.getMessage());
        }
    }

    private double getUnitPriceForDrink(String drinkType) {

        return switch (drinkType.toLowerCase()) {
            case "coffee" -> 250.00;
            case "tea" -> 120.00;
            case "latte" -> 350.50;
            case "juice" -> 150.00;
            case "soda" -> 180.00;
            default -> 0.0;
        };
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
    public List<Order> getOrdersByDrinkType(){
        return orders.stream()
                .filter(order -> getOrdersByDrinkType().equals(drinkType))
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersByBranch(String branchName) {
        return orders.stream()
                .filter(order -> order.getBranchName().equalsIgnoreCase(branchName))
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        return orders.stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public Optional<Order> getOrderById(String orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst();
    }
}