import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ContactBook book = new ContactBook();

        Contact c1 = new Contact("0991112233", "Ivan", "ivan@gmail.com");
        Contact c2 = new Contact("0504445566", "Maria", "maria@ukr.net");
        Contact c3 = new Contact("0678889900", "Petro", "petro@meta.ua");

        book.add(c1);
        book.add(c2);
        book.add(c3);

        System.out.println(" All Contacts");
        book.showAll();

        System.out.println("\nSearching for Maria ");
        book.find("0504445566");

        System.out.println("\nRemoving Petro");
        book.delete("0678889900");

        System.out.println("\n All Contacts Again ");
        book.showAll();
    }
}
class Contact {
    String phone;
    String name;
    String email;

    public Contact(String phone, String name, String email) {
        this.phone = phone;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

class ContactBook {

    private HashMap<String, Contact> contacts;

    public ContactBook() {
        contacts = new HashMap<>();
    }

    public void add(Contact contact) {
        contacts.put(contact.phone, contact);
        System.out.println("Added: " + contact.name);
    }

    public void delete(String phone) {
        Contact z = contacts.remove(phone);

        if (z != null) {
            System.out.println("Removed: " + z.name);
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