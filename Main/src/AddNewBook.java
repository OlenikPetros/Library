
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddNewBook {
  String name;

    public static void add (String name) {
        
    
        String url = "jdbc:mysql://localhost:3306/library"; // your database
        String user = "root"; // your DB username
        String password = ""; // your DB password

        String insertQuery = "INSERT INTO book (name) VALUES (?)";
        {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create a PreparedStatement
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, name);
            

            // Execute the insert
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("✅ A new person was inserted successfully!");
            }

            // Clean up
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }
}
    

