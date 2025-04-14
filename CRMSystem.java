package CustomerRelationship;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CRMSystem {
    private List<Customer> customers;
    private List<Interaction> interactions;

    public CRMSystem() {
        customers = new ArrayList<>();
        interactions = new ArrayList<>();
    }

    // Customer Management
    public void addCustomer(Customer customer) { customers.add(customer); }

    public Customer getCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void updateCustomer(int id, String name, String email, String phone, String type) {
        Customer c = getCustomerById(id);
        if (c != null) {
            c.setName(name);
            c.setEmail(email);
            c.setPhone(phone);
            c.setCustomerType(type);
            System.out.println("Customer updated!");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void deleteCustomer(int id) {
        customers.removeIf(c -> c.getId() == id);
        interactions.removeIf(i -> i.getCustomerId() == id);
        System.out.println("Customer and associated interactions deleted.");
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            customers.sort(Comparator.comparing(Customer::getName));
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    public void searchCustomer(String keyword) {
        boolean found = false;
        for (Customer c : customers) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                c.getEmail().toLowerCase().contains(keyword.toLowerCase()) ||
                c.getPhone().contains(keyword)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No matching customer found.");
    }

    // Interaction Management
    public void recordInteraction(Interaction interaction) { interactions.add(interaction); }

    public void listInteractionsForCustomer(int customerId) {
        List<Interaction> result = interactions.stream()
            .filter(i -> i.getCustomerId() == customerId)
            .sorted(Comparator.comparing(Interaction::getDate))
            .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No interactions found.");
        } else {
            for (Interaction i : result) {
                System.out.println(i);
            }
        }
    }

    public void reportCustomerActivity() {
        for (Customer c : customers) {
            long count = interactions.stream()
                .filter(i -> i.getCustomerId() == c.getId())
                .count();
            System.out.println(c.getName() + " - Interactions: " + count);
        }
    }

    public void exportData() {
        try (FileWriter writer = new FileWriter("CRM_Report.txt")) {
            writer.write("Customers:\n");
            for (Customer c : customers) {
                writer.write(c + "\n");
            }
            writer.write("\nInteractions:\n");
            for (Interaction i : interactions) {
                writer.write(i + "\n");
            }
            System.out.println("Data exported to CRM_Report.txt");
        } catch (IOException e) {
            System.out.println("Error exporting data: " + e.getMessage());
        }
    }
}
