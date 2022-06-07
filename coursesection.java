import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class coursesection {
   
    public static void coursesectmethod()
       throws SQLException
  {
    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        //String serverName = "cisvm-oracle.unfcsd.unf.edu";
        //String portNumber = "1521";
        //String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "T8";
        String password = "Spring2022T8";
        
			Connection conn = DriverManager.getConnection(url, username, password);

			
          PreparedStatement pstmt =
          conn.prepareStatement ("INSERT INTO COURSE_SECTION(Instructor, Semester, Year, Course, Scourse_Num, Section_number) " +
          "VALUES (?, ?, ?, ?, ?, ?)");
    int done = 1;
 
    while (done != 0) 
    {
try (Scanner scanner = new Scanner(System.in)) {
  try {
    System.out.println("\nEnter instructor's name: ");
    System.out.println("Note: This information is required to proceed.");
      String instructor = scanner.nextLine();
      System.out.println("\nEnter semester (i.e. Fall, Spring, Summer): ");
      System.out.println("Note: This information is required to proceed.");
      String semester = scanner.nextLine();
      System.out.println("\nEnter year: ");
      System.out.println("Or enter 3000 if unavailable.");
      int year = scanner.nextInt();   
      System.out.println("\nEnter course name: ");
      System.out.println("Note: This information is required to proceed.");
      scanner.nextLine();
      String course = scanner.nextLine();
      System.out.println("\nEnter course number: ");
      System.out.println("Format:AAA####");
      System.out.println("Or enter 0000000 if unavailable.");
      String scoursenum = scanner.nextLine(); 
      System.out.println("\nEnter section number: ");
      System.out.println("Note: This information is required to proceed.");
      String sectionnum = scanner.nextLine();
     
 
      pstmt.setString(1, instructor);
      pstmt.setString(2, semester);
      pstmt.setInt(3, year);
      pstmt.setString(4, course);
      pstmt.setString(5, scoursenum);
      pstmt.setString(6, sectionnum);
    }
    finally {
      int NumRows = pstmt.executeUpdate();
      System.out.println("\n" + NumRows + " row(s) inserted"); //Should be seven rows for course.
 
      
        System.out.println("\nEnter 0 to exit. ");
        System.out.println("\nEnter 1 to continue.");
        String exitchoice = scanner.nextLine();
           
           if (exitchoice.equals("0")) {
             System.out.println("You chose to exit the program.");
            // System.exit()
            return;
           }
           else if (exitchoice.equals("1")){
             System.out.println("You chose to continue.");
            frontend.main(null);
           }
           }
    
          }
      } // while done
    conn.close(); //Closes connection.
 
  } // main
 
}  
