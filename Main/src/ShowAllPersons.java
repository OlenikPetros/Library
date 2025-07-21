import java.sql.*;

public class ShowAllPersons {
 

    public static void showPersons() {
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
            String query = "SELECT * FROM person";

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Display results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name"); // Assuming you have a 'name' column
                System.out.println("ID: " + id + ", Name: " + name);
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
