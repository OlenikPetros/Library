import java.sql.*;

public class ShowAllPersons {
 

    public static void showPersons() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = ""; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM person";

            ResultSet rs = stmt.executeQuery(query);

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
