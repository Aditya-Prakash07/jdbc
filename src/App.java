
// Java database connectivity 
// 1. import --> java.sql
// 2. load and register the driver --> com.mysql.cj.jdbc.Driver
// 3. create connection
// 4. create a statement 
// 5. execute the query
// 6. process the result
// 7. close

// progress 001
// import java.sql.*;
// public class App {
//     public static void main(String[] args) throws Exception {



//        // fetching data from the database (one at time)


//         // String url = "jdbc:mysql://127.0.0.1:3306/aditya";
//         // String username = "root";
//         // String pass = "admin123";
//         // String query = "SELECT name FROM aditya.student WHERE rollno = 3";
//         // Class.forName("com.mysql.cj.jdbc.Driver");
//         // // Connection is an interface in java and so we can not make objects of it. So getConnection() a static method ( it returns the instance of connection) of class DriverManager is used which takes three parameters
//         // Connection con = DriverManager.getConnection(url, username, pass);
//         // //Statement is also an interface and createStatement() method returns the object of this interface
//         // Statement st = con.createStatement();
//         // // st.executeQuery(query) gives the data in table structure and the ResultSet has the power to store the data 
//         // ResultSet rs = st.executeQuery(query);
//         // // we need to do rs.next() as rs right now is pointing to the table heading by default
//         // rs.next();
//         // String name = rs.getString("name");
//         // System.out.println(name);
//         // sc.close();
//         // st.close();
//         // con.close();




//         //Fetching complete table form the database and printing that in the terminal


//         String url = "jdbc:mysql://127.0.0.1:3306/aditya";
//         String username = "root";
//         String pass = "admin123";
//         String query = "SELECT * FROM aditya.student";
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         // Connection is an interface in java and so we can not make objects of it. So getConnection() a static method ( it returns the instance of connection) of class DriverManager is used which takes three parameters
//         Connection con = DriverManager.getConnection(url, username, pass);
//         //Statement is also an interface and createStatement() method returns the object of this interface
//         Statement st = con.createStatement();
//         // st.executeQuery(query) gives the data in table structure and the ResultSet has the power to store the data 
//         ResultSet rs = st.executeQuery(query);
//         // we need to do rs.next() as rs right now is pointing to the table heading by default. rs.next() moves the pointer to the next row in the table 
//         String userData = "";
//         while(rs.next()){
//             userData = rs.getInt(1)+ " : " + rs.getString("name");
//             System.out.println(userData);
//         }
//         st.close();
//         con.close();
        
//     }
// }




// // insert values in the database

// import java.sql.*;
// import java.util.Scanner;
// public class App {

//     public static void main(String[] args) throws Exception{
//         Scanner sc = new Scanner(System.in);


//         String url = "jdbc:mysql://127.0.0.1:3306/aditya";
//         String username = "root";
//         String pass = "admin123";
//         String name = "Sohail";
//        // String query = "INSERT INTO aditya.student (name) VALUE('Ubashi')"; //Directly inserting value through query
//         String query = "INSERT INTO aditya.student (name) VALUES ('" + name + "')"; // Inserting values stored in a variable 
//         Class.forName("com.mysql.cj.jdbc.Driver");


//         // Connection is an interface in java and so we can not make objects of it. So getConnection() a static method ( it returns the instance of connection) of class DriverManager is used which takes three parameters


//         Connection con = DriverManager.getConnection(url, username, pass);


//         //Statement is also an interface and createStatement() method returns the object of this interface
//         Statement st = con.createStatement(); // Using Statement for insert operations is not a good practice we need to use PreparedStatement


//         // st.executeQuery(query) gives the data in table structure and the ResultSet has the power to store the data 
//       //  ResultSet rs = st.executeQuery(query); // whenever we interact with the database and we need to fetch data from the database we using executeQuery method . (DQL ----> data query language)

//        // While insertig the data in the database we are not fetching the data form the data base so we need to execute executeUpdate() (it returns the number of rows afected)  insted of executeQuery() ;

//         int count = st.executeUpdate(query);

//         System.out.println(count + " row/s affected");


//         sc.close();
//         st.close();
//         con.close();
//     }
// }









// insert values in the database (USING PREPARED STATEMENT)

import java.sql.*;
import java.util.Scanner;
public class App {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);


        String url = "jdbc:mysql://127.0.0.1:3306/aditya";
        String username = "root";
        String pass = "admin123";
        String name = "Gutka wala";
        String query = "INSERT INTO aditya.student (name) VALUES (?)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, username, pass);

        PreparedStatement st = con.prepareStatement(query); // THE QUERY IS FIXED BUT THE VALUE IS CHANGING so using PreparedStatement
        st.setString(1, name);

        // st.executeQuery(query) gives the data in table structure and the ResultSet has the power to store the data 
      //  ResultSet rs = st.executeQuery(query); // whenever we interact with the database and we need to fetch data from the database we using executeQuery method . (DQL ----> data query language)

       

        int count = st.executeUpdate(); // we can also write update , delete and insert query over here things to study on your own

        System.out.println(count + " row/s affected");


        sc.close();
        st.close();
        con.close();
    }
}


//DAO(data access object ) it is a designed layer it is always prefferd to write your data base related stuffs inside the dao layer only