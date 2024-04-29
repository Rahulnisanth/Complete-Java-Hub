import java.util.*;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter contact email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter contact location: ");
                    String location = scanner.nextLine();
                    Contact newContact = new Contact(name, phone, email, location);
                    contactBook.addContact(newContact);
                    System.out.println("Contact added successfully.");
                    break;
                case "2":
                    contactBook.viewContacts();
                    break;
                case "3":
                    System.out.print("Enter search keyword (name or location)/(phone or email): ");
                    String keyword = scanner.nextLine();
                    contactBook.searchContact(keyword);
                    break;
                case "4":
                    System.out.print("Enter the name of the contact to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    contactBook.updateContact(updateName, newPhoneNumber);
                    break;
                case "5":
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    contactBook.deleteContact(deleteName);
                    break;
                case "6":
                    System.out.println("Exiting Contact Book...!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
