import java.sql.*;

public class ShowAllBooks {
 

    public static void showBooks() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = ""; 

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement stmt = conn.createStatement();

            // SQL query
            String query = "SELECT * FROM book";

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Display results
            System.out.println("Books:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int free = rs.getInt("free");
String freeStr; 
 if(free == 1)
freeStr="Available";


else
    freeStr="Not Available";




                System.out.println("ID: " + id + ", Name: " + name + "  "+freeStr );
            }

            // Close everything
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
