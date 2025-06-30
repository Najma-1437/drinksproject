package com.managementstore.managementdrinks.controller;
import java.util.Scanner;
import com.managementstore.managementdrinks.manager.CustomerManager;
import com.managementstore.managementdrinks.model.Customer;

public class CustomerCLI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer ID:");
        String id = scanner.nextLine ();

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Contact:");
        String contact = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Preferred Branch:");
        String branch = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, contact, email, branch);
        CustomerManager.addCustomer(newCustomer);

    }}