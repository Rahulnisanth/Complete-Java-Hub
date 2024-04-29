import java.util.*;
class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Message: Your contact book is empty.");
        } else {
            for (Contact contact : contacts) {
                System.out.println("Name: " + contact.getName() + "    Phone: " + contact.getPhone());
            }
        }
    }

    public void searchContact(String keyword) {
        List<Contact> found = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    contact.getPhone().contains(keyword) ||
                    contact.getEmail().contains(keyword) ||
                    contact.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                found.add(contact);
            }
        }
        if (found.isEmpty()) {
            System.out.println("Message: No matching contacts found.");
        } else {
            System.out.println("Matching contacts for '" + keyword + "'");
            for (Contact contact : found) {
                System.out.println("Name: " + contact.getName() + "    Phone: " + contact.getPhone());
            }
        }
    }

    public void updateContact(String name, String newNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setPhone(newNumber);
                System.out.println("Message: Contact updated successfully.");
                return;
            }
        }
        System.out.println("Message: Contact not found.");
    }

    public void deleteContact(String name) {
        Contact foundContact = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                foundContact = contact;
                break;
            }
        }
        if (foundContact != null) {
            contacts.remove(foundContact);
            System.out.println("Message: Contact deleted successfully.");
        } else {
            System.out.println("Message: Contact not found.");
        }
    }
}