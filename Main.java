import java.util.List;

public class Main {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService(customerService);

        System.out.println(" Adding Sample Customers");
        Customer cust1 = new Customer("CUST001", "Alice Wanjiru", "0712234590", "alice@example.com", "Nakuru Branch");
        Customer cust2 = new Customer("CUST002", "Johnson Salome", "0722348909", "bob@example.com", "Kisumu Branch");
        Customer cust3 = new Customer("CUST003", "Charlie Weteithie", "0798657892", "charlie@example.com", "Nairobi Branch");
        Customer cust4 = new Customer("CUST004", "Diana Wahome", "0198745637", "diana@example.com", "Mombasa Branch");

        customerService.addCustomer(cust1);
        customerService.addCustomer(cust2);
        customerService.addCustomer(cust3);
        customerService.addCustomer(cust4);
        System.out.println("\n");

        System.out.println("Sample Orders");
        orderService.placeOrder(cust1.getCustomerId(), "CUST001","Coffee", 2, "Nakuru Branch");
        orderService.placeOrder(cust2.getCustomerId(),"CUST002", "Tea", 1, "Kisumu Branch");
        orderService.placeOrder(cust1.getCustomerId(), "CUST001","Juice", 3, "Nakuru Branch");
        orderService.placeOrder(cust3.getCustomerId(), "CUST003","Soda", 4, "Mombasa Branch");
        orderService.placeOrder(cust2.getCustomerId(), "CUST002","Coffee", 1, "Nairobi Branch");


        System.out.println("\n");

        // Retrieve and Display Orders
        System.out.println("All Placed Orders ");
        List<Order> allOrders = orderService.getAllOrders();
        if (allOrders.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            allOrders.forEach(order -> System.out.println(order.getOrderSummary()));
        }
        System.out.println("\n");


        System.out.println("Orders from Nakuru Branch");
        List<Order> nakuruOrders = orderService.getOrdersByBranch("Nakuru Branch");
        nakuruOrders.forEach(order -> System.out.println(order.getOrderSummary()));
        System.out.println("\n");


        System.out.println("Orders by Alice Wanjiru");
        List<Order> aliceOrders = orderService.getOrdersByCustomerId(cust1.getCustomerId());
        aliceOrders.forEach(order -> System.out.println(order.getOrderSummary()));
        System.out.println("\n");

    }
}