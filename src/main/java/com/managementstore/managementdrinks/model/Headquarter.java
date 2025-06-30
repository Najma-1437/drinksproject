package com.managementstore.managementdrinks.model;
public class Headquarter extends Branch {
    public Headquarter() {
        super("NAIROBI");
    }

    // Restock a branch
    public void restockBranch(Branch branch, Drink drink, int quantity) {
        branch.addStock(drink, quantity);
        System.out.println("Restocked " + drink.getName() + " at " + branch.getLocation());
    }
}