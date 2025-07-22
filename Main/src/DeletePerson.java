import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DeletePerson{

    public static void delperson(String bookId) {
        String url = "jdbc:mysql://localhost:3306/library"; 
        String user = "root"; 
        String password = ""; 
        String deleteQuery = "DELETE FROM book WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Update book status
            try (PreparedStatement updateStmt = conn.prepareStatement(deleteQuery)) {
                updateStmt.setString(1, bookId);
int rowsDeleted = updateStmt.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println(" Person Deleted!");
                } else {
                    System.out.println("⚠️ No person found with that ID.");
                }
       }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
