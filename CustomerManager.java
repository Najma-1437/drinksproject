import java.util.HashMap;

public class CustomerManager {
    private static HashMap<String, Customer > customers = new HashMap<>();

    public static void addCustomer(Customer customer) { // Correct method name (case-sensitive)
        if(!customers.containsKey(customer.getCustomerId())) { // Remove semicolon
            customers.put(customer.getCustomerId(), customer);
        }
        else {
            System.out.println("Error: Duplicate customer ID");
        }
    }
    public static Customer getCustomerByID(String customerId){
        return customers.get(customerId);
    }
    public static void linkOrderToCustomer(String customerId, String orderId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            customer.addOrderId(orderId);
        }
    }
}

