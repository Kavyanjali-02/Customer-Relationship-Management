package CustomerRelationship;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String customerType;

    public Customer(int id, String name, String email, String phone, String customerType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCustomerType() { return customerType; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCustomerType(String customerType) { this.customerType = customerType; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email +
               ", Phone: " + phone + ", Type: " + customerType;
    }
}
