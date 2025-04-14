package CustomerRelationship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CRMSystem crm = new CRMSystem();
        Scanner scanner = new Scanner(System.in);
        int customerIdCounter = 1;

        while (true) {
            System.out.println("\n--- CRM MENU ---");
            System.out.println("1. Add Customer");
            System.out.println("2. List Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Search Customer");
            System.out.println("6. Record Interaction");
            System.out.println("7. View Interactions by Customer ID");
            System.out.println("8. Customer Activity Report");
            System.out.println("9. Export Data to File");
            System.out.println("10. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter customer type (Regular/VIP/etc): ");
                    String type = scanner.nextLine();
                    Customer customer = new Customer(customerIdCounter++, name, email, phone, type);
                    crm.addCustomer(customer);
                    System.out.println("Customer added!");
                    break;

                case 2:
                    crm.listCustomers();
                    break;

                case 3:
                    System.out.print("Enter Customer ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter new customer type: ");
                    String newType = scanner.nextLine();
                    crm.updateCustomer(updateId, newName, newEmail, newPhone, newType);
                    break;

                case 4:
                    System.out.print("Enter Customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    crm.deleteCustomer(deleteId);
                    break;

                case 5:
                    System.out.print("Enter name/email/phone keyword to search: ");
                    String keyword = scanner.nextLine();
                    crm.searchCustomer(keyword);
                    break;

                case 6:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter interaction notes: ");
                    String notes = scanner.nextLine();
                    System.out.print("Enter interaction type (Call/Email/Meeting): ");
                    String interactionType = scanner.nextLine();
                    crm.recordInteraction(new Interaction(customerId, notes, interactionType));
                    System.out.println("Interaction recorded!");
                    break;

                case 7:
                    System.out.print("Enter Customer ID: ");
                    int custId = scanner.nextInt();
                    crm.listInteractionsForCustomer(custId);
                    break;

                case 8:
                    crm.reportCustomerActivity();
                    break;

                case 9:
                    crm.exportData();
                    break;

                case 10:
                    System.out.println("Exiting CRM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
