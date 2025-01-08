
// Java database connectivity 
// 1. import --> java.sql
// 2. load and register the driver --> com.mysql.cj.jdbc.Driver
// 3. create connection
// 4. create a statement 
// 5. execute the query
// 6. process the result
// 7. close


import java.sql.*;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://127.0.0.1:3306/aditya";
        String username = "root";
        String pass = "admin123";
        String query = "SELECT * FROM aditya.student WHERE rollno = 2";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection is an interface in java and so we can not make objects of it. So getConnection() a static method ( it returns the instance of connection) of class DriverManager is used which takes three parameters
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name = rs.getString("name");
        System.out.println(name);
        sc.close();
        st.close();
        con.close();
        
    }
}
