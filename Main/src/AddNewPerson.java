
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddNewPerson {

    public static void AddPerson(String name) {
        
    
        String url = "jdbc:mysql://localhost:3306/library"; 
        String user = "root"; 
        String password = ""; 

        String insertQuery = "INSERT INTO person (name,) VALUES (?)";
        {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, name);
            

            // Execute the insert
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("✅ A new person was inserted successfully!");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

   
}
    

