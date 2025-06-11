public class Customer {
    private final String customerId;
    private final String name;
    private String contact;  // Not final because it can be updated
    private final String email;
    private final String preferredBranch;

    public Customer(String customerId, String name, String contact, String email, String preferredBranch) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.preferredBranch = preferredBranch;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPreferredBranch() {
        return preferredBranch;
    }

    public void updateContact(String newContact) {
        this.contact = newContact;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer ID: %s\nName: %s\nContact: %s\nEmail: %s\nPreferred Branch: %s",
                customerId, name, contact, email, preferredBranch
        );
    }
}