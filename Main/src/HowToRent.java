import java.util.List;
 public class HowToRent {

    public static void allPersonsAndBooks() {
        List<String> books = FreeBooks.showFreeBooks();
        List<String> persons = AllPersons.showAllPersons();

        // Calculate max rows (max length)
        int maxRows = Math.max(books.size(), persons.size());

        // Create 2D array [maxRows][2] -> column 0: books, column 1: persons
        String[][] combined = new String[maxRows][2];

        for (int i = 0; i < maxRows; i++) {
            combined[i][0] = (i < books.size()) ? books.get(i) : "";
            combined[i][1] = (i < persons.size()) ? persons.get(i) : "";
        }

        // Print side by side
        System.out.printf("%-30s | %-30s%n", "Books (free=0)", "Persons");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < maxRows; i++) {
            System.out.printf("%-30s | %-30s%n", combined[i][0], combined[i][1]);
        }
    }
}
 