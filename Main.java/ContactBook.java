import java.util.HashMap;

public class ContactBook {

    private HashMap<String, Contact> contacts;

    public ContactBook() {
        contacts = new HashMap<>();
    }

    public void add(Contact contact) {
        contacts.put(contact.getPhone(), contact);
        System.out.println("Added: " + contact.getName());
    }

    public void delete(String phone) {
        Contact z = contacts.remove(phone);

        if (z != null) {
            System.out.println("Removed: " + z.getName());
        } else {
            System.out.println("Number not found: " + phone);
        }
    }

    public void find(String phone) {
        Contact z = contacts.get(phone);

        if (z != null) {
            System.out.println("Found: " + z.toString());
        } else {
            System.out.println("Number not found: " + phone);
        }
    }

    public void showAll() {
        if (contacts.isEmpty()) {
            System.out.println("Book is empty.");
            return;
        }

        System.out.println("List:");
        for (Contact c : contacts.values()) {
            System.out.println(" - " + c.toString());
        }
    }
}