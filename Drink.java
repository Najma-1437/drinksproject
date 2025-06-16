public class Drink {
    private String name;
    private double basePrice; // Price in Ksh

    public Drink(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    // Getters
    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }
}