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