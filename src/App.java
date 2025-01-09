
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


import java.sql.*;

class Student{
    int rollno;
    String name;
    
}
class StudentDao{
    public Student getStudent(int rollno){
        String url = "jdbc:mysql://127.0.0.1:3306/aditya";
        String username = "root";
        String pass = "admin123";
        try{
            String query = "SELECT name FROM student WHERE rollno = "+rollno;
            Student s = new Student();
            s.rollno = rollno;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, pass);
           
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString(1);
            s.name = name;
            return s;
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
public class App {

    public static void main(String[] args) throws Exception{
       StudentDao dao = new StudentDao();
       Student s1 = dao.getStudent(12);
      // StudentDao.addStudent("Nanhak"); // Implement this by your self
       System.out.println(s1.name);
    }
}