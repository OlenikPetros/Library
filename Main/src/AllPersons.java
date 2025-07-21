import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllPersons {
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

