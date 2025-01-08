
// Java database connectivity 
// 1. import --> java.sql
// 2. load and register the driver --> com.mysql.cj.jdbc.Driver
// 3. create connection
// 4. create a statement 
// 5. execute the query
// 6. process the result
// 7. close

// progress 001
import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {



       // fetching data from the database (one at time)


        // String url = "jdbc:mysql://127.0.0.1:3306/aditya";
        // String username = "root";
        // String pass = "admin123";
        // String query = "SELECT name FROM aditya.student WHERE rollno = 3";
        // Class.forName("com.mysql.cj.jdbc.Driver");
        // // Connection is an interface in java and so we can not make objects of it. So getConnection() a static method ( it returns the instance of connection) of class DriverManager is used which takes three parameters
        // Connection con = DriverManager.getConnection(url, username, pass);
        // //Statement is also an interface and createStatement() method returns the object of this interface
        // Statement st = con.createStatement();
        // // st.executeQuery(query) gives the data in table structure and the ResultSet has the power to store the data 
        // ResultSet rs = st.executeQuery(query);
        // // we need to do rs.next() as rs right now is pointing to the table heading by default
        // rs.next();
        // String name = rs.getString("name");
        // System.out.println(name);
        // sc.close();
        // st.close();
        // con.close();




        //Fetching complete table form the database and printing that in the terminal


        String url = "jdbc:mysql://127.0.0.1:3306/aditya";
        String username = "root";
        String pass = "admin123";
        String query = "SELECT * FROM aditya.student";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection is an interface in java and so we can not make objects of it. So getConnection() a static method ( it returns the instance of connection) of class DriverManager is used which takes three parameters
        Connection con = DriverManager.getConnection(url, username, pass);
        //Statement is also an interface and createStatement() method returns the object of this interface
        Statement st = con.createStatement();
        // st.executeQuery(query) gives the data in table structure and the ResultSet has the power to store the data 
        ResultSet rs = st.executeQuery(query);
        // we need to do rs.next() as rs right now is pointing to the table heading by default. rs.next() moves the pointer to the next row in the table 
        String userData = "";
        while(rs.next()){
            userData = rs.getInt(1)+ " : " + rs.getString("name");
            System.out.println(userData);
        }
        st.close();
        con.close();
        
    }
}
