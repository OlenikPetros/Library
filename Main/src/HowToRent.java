import java.util.List;
import java.sql.*;
import java.util.ArrayList;
  public class HowToRent {

    public static void allPersonsAndBooks() {
        List<String> books = HowToRent.showFreeBooks();
        List<String> persons = HowToRent.showAllPersons();

        int maxRows = Math.max(books.size(), persons.size());

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
    
    public static List<String> showFreeBooks() {
        List<String> books = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement stmt = conn.createStatement();
            String query = "SELECT id, name FROM book WHERE free = 0";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                books.add(rs.getInt("id") + ": " + rs.getString("name"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }
     public static List<String> showAllPersons() {
        List<String> books = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            Statement stmt = conn.createStatement();
            String query = "SELECT id, name FROM person ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                books.add(rs.getInt("id") + ": " + rs.getString("name"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }
}
 



