import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (customer != null) {
            boolean exists = customers.stream()
                    .anyMatch(c -> c.getCustomerId().equals(customer.getCustomerId()));
            if (!exists) {
                customers.add(customer);
                System.out.println("Customer added: " + customer.getName() + " (ID: " + customer.getCustomerId() + ")");
            } else {
                System.out.println("Error: Customer with ID " + customer.getCustomerId() + " already exists.");
            }
        } else {
            System.out.println("Error: Cannot add a null customer.");
        }
    }

    public Optional<Customer> getCustomerById(String customerId) {
        return customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst();
    }


    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }
}