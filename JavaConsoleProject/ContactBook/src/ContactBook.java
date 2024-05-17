// import java.util.*;
import java.sql.*;
class ContactBook {
    // Sql connection Strings :
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/contactbook";

    public ContactBook() {
        try {
            // Connect to the database
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addContact(Contact contact) {
        String name = contact.getName();
        String phoneNumber = contact.getPhone();
        String email = contact.getEmail();
        String location = contact.getLocation();
        try {
            // Prepare a statement to insert data
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `contacts`(`Name`, `Phone`, `Email`, `Location`) VALUES (?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.setString(4, location);
            // Execute the statement
            statement.executeUpdate();
            System.out.println("Contact added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewContacts() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");

            System.out.println("Name\t\tPhone Number\t\tLocation");
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String phoneNumber = resultSet.getString("Phone");
                String location = resultSet.getString("Location");
                System.out.println(name + "\t\t" + phoneNumber + "\t\t" + location);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchContact(String keyword) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM contacts WHERE Name = ?");
            statement.setString(1, keyword);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Contact found:");
                System.out.println("Name\t\tPhone Number\t\tLocation");
                String contactName = resultSet.getString("Name");
                String phoneNumber = resultSet.getString("Phone");
                String location = resultSet.getString("Location");
                System.out.println(contactName + "\t\t" + phoneNumber + "\t\t" + location);
            } else {
                System.out.println("Contact not found.");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateContact(String name, String newPhoneNumber, String newEmail, String newLocation) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE contacts SET Phone = ?, email = ?, Location = ? WHERE Name = ?");
            statement.setString(1, newPhoneNumber);
            statement.setString(2, newEmail);
            statement.setString(3, newLocation);
            statement.setString(4, name);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Contact not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM contacts WHERE Name = ?");
            statement.setString(1, name);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Contact not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}