import java.util.*;
import java.sql.*;
class ContactBook {
    // Sql connection Strings :
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/contactbook";

    // private List<Contact> contacts;

    public ContactBook() {
        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        String name = contact.getName();
        int phoneNumber = contact.getPhone();
        String email = contact.getEmail();
        String location = contact.getLocation();
        try {
            // Prepare a statement to insert data
            PreparedStatement statement = connection.prepareStatement("INSERT INTO contacts (name, phone_number, email, location) VALUES (?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setInt(2, phoneNumber);
            statement.setString(3, email);
            statement.setString(4, location);

            // Execute the statement
            statement.executeUpdate();
            System.out.println("Contact added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public void viewContacts() {
    //     if (contacts.isEmpty()) {
    //         System.out.println("Message: Your contact book is empty.");
    //     } else {
    //         for (Contact contact : contacts) {
    //             System.out.println("Name: " + contact.getName() + "    Phone: " + contact.getPhone());
    //         }
    //     }
    // }

    // public void searchContact(String keyword) {
    //     List<Contact> found = new ArrayList<>();
    //     for (Contact contact : contacts) {
    //         if (contact.getName().toLowerCase().contains(keyword.toLowerCase()) ||
    //                 contact.getPhone().contains(keyword) ||
    //                 contact.getEmail().contains(keyword) ||
    //                 contact.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
    //             found.add(contact);
    //         }
    //     }
    //     if (found.isEmpty()) {
    //         System.out.println("Message: No matching contacts found.");
    //     } else {
    //         System.out.println("Matching contacts for '" + keyword + "'");
    //         for (Contact contact : found) {
    //             System.out.println("Name: " + contact.getName() + "    Phone: " + contact.getPhone());
    //         }
    //     }
    // }

    // public void updateContact(String name, String newNumber) {
    //     for (Contact contact : contacts) {
    //         if (contact.getName().equalsIgnoreCase(name)) {
    //             contact.setPhone(newNumber);
    //             System.out.println("Message: Contact updated successfully.");
    //             return;
    //         }
    //     }
    //     System.out.println("Message: Contact not found.");
    // }

    // public void deleteContact(String name) {
    //     Contact foundContact = null;
    //     for (Contact contact : contacts) {
    //         if (contact.getName().equalsIgnoreCase(name)) {
    //             foundContact = contact;
    //             break;
    //         }
    //     }
    //     if (foundContact != null) {
    //         contacts.remove(foundContact);
    //         System.out.println("Message: Contact deleted successfully.");
    //     } else {
    //         System.out.println("Message: Contact not found.");
    //     }
    // }
}