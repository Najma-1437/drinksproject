import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {
    private List<Order> orders;
    private CustomerService customerService;
    private List<String> drinkType;

    public OrderService(CustomerService customerService) {
        this.orders = new ArrayList<>();
        this.customerService = customerService;
    }

    public Order placeOrder(String orderId,String customerId, String drinkType, int quantity, String branchName) {

        Optional<Customer> customerOptional = customerService.getCustomerById(customerId);
        if (!customerOptional.isPresent()) {
            System.err.println("Error: Customer with ID '" + customerId + "' not found. Order cannot be placed.");
            return null;
        }


        double unitPrice = getUnitPriceForDrink(drinkType);
        if (unitPrice <= 0) {
            System.err.println("Error: Invalid or unknown drink type '" + drinkType + "'. Cannot place order.");
            return null;
        }

        try {
            Order order = new Order(orderId,customerId, drinkType, quantity, branchName, unitPrice);
            orders.add(order);
            System.out.println("Order placed: " + order.getOrderSummary());
            if(order != null){
                CustomerManager.linkOrderToCustomer(customerId, orderId);
            }
            return order;
        } catch (IllegalArgumentException e) {
            System.err.println("Error placing order: " + e.getMessage());
            return null;
        }
    }

    private double getUnitPriceForDrink(String drinkType) {

        switch (drinkType.toLowerCase()) {
            case "coffee": return 250.00;
            case "tea": return 120.00;
            case "latte": return 350.50;
            case "juice": return 150.00;
            case "soda": return 180.00;
            default: return 0.0;
        }
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