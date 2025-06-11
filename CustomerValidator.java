public class CustomerValidator {
    public static boolean isValidEmail(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhone(String phone) {

        return phone.matches("^[0-9]{10,12}$");
    }
}
