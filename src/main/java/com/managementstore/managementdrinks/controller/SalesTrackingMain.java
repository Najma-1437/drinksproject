package com.managementstore.managementdrinks.controller;

import com.managementstore.managementdrinks.model.Branch;
import com.managementstore.managementdrinks.model.Drink;
import com.managementstore.managementdrinks.model.Headquarter;
import com.managementstore.managementdrinks.model.SalesTracker;
public class SalesTrackingMain {
    public static void main(String[] args) {
        // 1. Define drinks
        Drink cocaCola = new Drink("Coca-Cola", 150.00);
        Drink pepsi = new Drink("Pepsi", 120.00);

        // 2. Initialize branches and HQ
        Branch nakuru = new Branch("NAKURU");
        Headquarter hq = new Headquarter();

        // 3. HQ restocks branches
        hq.restockBranch(nakuru, cocaCola, 50); // Add 50 Coca-Colas
        hq.restockBranch(nakuru, pepsi, 30);    // Add 30 Pepsis

        // 4. Record sales
        nakuru.recordSale(cocaCola); // Sell 1 Coca-Cola (Ksh 150)
        nakuru.recordSale(pepsi);    // Sell 1 Pepsi (Ksh 120)

        // 5. Track sales globally
        SalesTracker tracker = new SalesTracker();
        tracker.recordSale(cocaCola);
        tracker.recordSale(pepsi);

        // 6. Generate reports
        System.out.println("----- Stock Levels -----");
        System.out.printf("Nakuru %s: %d units\n", cocaCola.getName(), nakuru.getStock(cocaCola));
        System.out.printf("Nakuru %s: %d units\n", pepsi.getName(), nakuru.getStock(pepsi));

        System.out.println("\n----- Sales Report -----");
        tracker.generateSalesReport();

        System.out.printf("\nTotal Sales at Nakuru: Ksh %.2f\n", nakuru.getTotalSales());
    }
}
