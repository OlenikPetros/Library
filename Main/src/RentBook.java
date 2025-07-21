import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RentBook {

    public static void addrentbook(int bookId, int personId) {
        String url = "jdbc:mysql://localhost:3306/library"; // your database
        String user = "root"; // your DB username
        String password = ""; // your DB password

        String insertQuery = "INSERT INTO rentedbooks (bookname, persons_name) VALUES (?, ?)";
        String updateQuery = "UPDATE book SET free = 1 WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Insert rent record
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, bookId);
                insertStmt.setInt(2, personId);
                int rowsInserted = insertStmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("✅ A new rent entry was inserted successfully!");
                }
            }

            // Update book status
            try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                updateStmt.setInt(1, bookId);
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("✅ Book status updated to rented!");
                } else {
                    System.out.println("⚠️ No book found with that ID.");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
