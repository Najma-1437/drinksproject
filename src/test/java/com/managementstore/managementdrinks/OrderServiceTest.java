package com.managementstore.managementdrinks;

import com.managementstore.managementdrinks.service.OrderService;
import com.managementstore.managementdrinks.model.Order;

import org.junit.Before;


public class OrderServiceTest{

    private CustomerService customerService;

    private OrderService orderService;
    private Customer cust1, cust2, cust3;

    @Before
    public void setUp() {
        customerService = new CustomerService();
        orderService = new OrderService(customerService);

        cust1 = new Customer("CUST001_TEST", "Alice Test", "111-TEST", "alice.test@example.com", "Test Branch A");
        cust2 = new Customer("CUST002_TEST", "Bob Test", "222-TEST", "bob.test@example.com", "Test Branch B");
        cust3 = new Customer("CUST003_TEST", "Charlie Test", "333-TEST", "charlie.test@example.com", "Test Branch C");

        customerService.addCustomer(cust1);
        customerService.addCustomer(cust2);
        customerService.addCustomer(cust3);
    }


}