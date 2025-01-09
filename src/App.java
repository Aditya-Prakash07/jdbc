
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

// import java.sql.*;
// import java.util.Scanner;
// public class App {

//     public static void main(String[] args) throws Exception{
//         Scanner sc = new Scanner(System.in);


//         String url = "jdbc:mysql://127.0.0.1:3306/aditya";
//         String username = "root";
//         String pass = "admin123";
//         String name = "BAHU BHAIYA";
//         String query = "INSERT INTO aditya.student (name) VALUES (?)";

//         Class.forName("com.mysql.cj.jdbc.Driver");

//         Connection con = DriverManager.getConnection(url, username, pass);

//         PreparedStatement st = con.prepareStatement(query); // THE QUERY IS FIXED BUT THE VALUE IS CHANGING so using PreparedStatement
//         st.setString(1, name);

//         // st.executeQuery(query) gives the data in table structure and the ResultSet has the power to store the data 
//       //  ResultSet rs = st.executeQuery(query); // whenever we interact with the database and we need to fetch data from the database we using executeQuery method . (DQL ----> data query language)

       

//         int count = st.executeUpdate(); // we can also write update , delete and insert query over here things to study on your own

//         System.out.println(count + " row/s affected");


//         sc.close();
//         st.close();
//         con.close();
//     }
// }






// //Class.forName()...method--understanding


// import java.sql.DriverManager;

// class Pqr{
//     //Static Block
//     static{
//         System.out.println("Inside Static Block");
//     }
//     // Instance Block
//     {
//         System.out.println("Inside Instance Block");
//     }
// }

// public class App {

//     public static void main(String[] args) throws Exception{
//        // Pqr pqr = new Pqr(); // whenever we create an object so before creating the object it will first load the class (static method will be called), while we are creating the object it will call the instance block .
//         //what if we don't want to create the object but still i want to call the static block in this scenerio we can just load the class using the Class.forName(class_name);
//         //Class.forName("Pqr");// class loading
//         //Class.forName("Pqr").getDeclaredConstructor().newInstance(); // class loading + instance creation

//         //tow ways to load the driver 
//         //1.
//         Class.forName("com.mysql.cj.jdbc.Driver"); // Preffered
//         //2.
//         DriverManager.registerDriver("com.mysql.cj.jdbc.Driver");
//         // both 1 & 2 are same thats because whenever you go to the driver class of mysql connecter in this you have a static block and this static block does the same thing that we are trying to do in 2nd type. so whenever we call the Class.forName() it loads the class and whenever it loads it will execute the static block . and whenever it executes the static block it will call the method register driver , That means we do not need to write the statement in 2nd type. Because we are writing Class.forName()..

//         // So that means whenever we try to register the driver the Class.forName() is not the method which register the driver. Its actually the static block of driver class which register the driver.

//     }
// }







//DAO(data access object ) it is a designed layer it is always prefferd to write your data base related stuffs inside the dao layer only

// ______________________________________________XXXXXXXXXXXXXXXXX not working XXXXXXXXXXXXXXX______________________________________________
// import java.sql.*;

// class Student{
//     int rollno;
//     String name;
    
// }
// class StudentDao{
//     Connection con = null;
//     public void connect(){
//         // String url = "jdbc:mysql://127.0.0.1:3306/aditya";
//         // String username = "root";
//         // String pass = "admin123";
//         try{
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aditya", "root", "admin123");
//         }
//         catch(Exception ex){
//             System.out.println(ex);
//         }
       
//     }
//     public Student getStudent(int rollno){
//         try{
//             String query = "SELECT name FROM student WHERE rollno = "+rollno;
//             Student s = new Student();
//             s.rollno = rollno;
           
           
           
//             Statement st = con.createStatement();
            
//             ResultSet rs = st.executeQuery(query);
//             rs.next();
//             String name = rs.getString(1);
//             s.name = name;
//             return s;
//         }
//         catch(Exception ex){
//             System.out.println(ex);
//         }
//         return null;
//     }
//     public void addStudent(Student s){
//         String query = "insert into aditya.student (name) value (?)";
//         PreparedStatement pst;
//         try{

//             pst = con.prepareStatement(query);
//             pst.setString(2, s.name);
//             pst.executeUpdate();
//         }
//         catch(Exception ex){
//             System.out.println(ex);
//         }
//     }



// }
// public class App {

//     public static void main(String[] args) throws Exception{
//        StudentDao dao = new StudentDao();
//        Student s1 = new Student();
//        s1.name = "Nanhak";
//        dao.connect();
//        dao.addStudent(s1);
//     //    Student s2 = dao.getStudent(13);
//     //    System.out.println(s2.name);
//     }
// }




// _______________________________________________XXXXXXXXXXXXXXXXX working XXXXXXXXXXXXXXX__________________________________________________

import java.sql.*;

// Class representing a Student entity
class Student {
    int rollno; // Roll number of the student
    String name; // Name of the student
}

// Data Access Object (DAO) class for Student
class StudentDao {
    // Connection object for connecting to the database
    private Connection con = null;

    /**
     * Establishes a connection to the database.
     */
    public void connect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection using DriverManager
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aditya", "root", "admin123");
            System.out.println("Connection established successfully!");
        } catch (Exception ex) {
            System.out.println("Connection failed: " + ex);
        }
    }

    /**
     * Retrieves a student record from the database based on the roll number.
     *
     * @param rollno The roll number of the student to retrieve.
     * @return A Student object containing the retrieved data, or null if not found.
     */
    public Student getStudent(int rollno) {
        try {
            // SQL query to retrieve the student's name based on roll number
            String query = "SELECT name FROM student WHERE rollno = " + rollno;

            // Create a new Student object
            Student s = new Student();
            s.rollno = rollno;

            // Create a Statement object to execute the query
            Statement st = con.createStatement();

            // Execute the query and get the result set
            ResultSet rs = st.executeQuery(query);

            // Check if a record is found
            if (rs.next()) {
                s.name = rs.getString(1); // Retrieve the name from the first column
                return s; // Return the populated Student object
            } else {
                System.out.println("No student found with rollno: " + rollno);
            }
        } catch (Exception ex) {
            System.out.println("Error fetching student: " + ex);
        }
        return null; // Return null if no student is found or an error occurs
    }

    /**
     * Adds a new student to the database.
     *
     * @param s The Student object containing the data to insert.
     */
    public void addStudent(Student s) {
        // SQL query to insert a new student record
        String query = "INSERT INTO student (name) VALUES (?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            // Set the value for the first parameter
            pst.setString(1, s.name);

            // Execute the update
            pst.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (Exception ex) {
            System.out.println("Error adding student: " + ex);
        }
    }
}

// Main class to test the DAO functionality
public class App {
    public static void main(String[] args) {
        // Create an instance of the DAO
        StudentDao dao = new StudentDao();

        // Establish a connection to the database
        dao.connect();

        // Create a new student object and add it to the database
        Student s1 = new Student();
        s1.name = "Fannu";
        dao.addStudent(s1);

        // Retrieve a student by roll number and print their name
        Student s2 = dao.getStudent(16);
        if (s2 != null) {
            System.out.println("Student Name: " + s2.name);
        }
    }
}
