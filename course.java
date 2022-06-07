import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class course {
   
  public static void coursemethod()
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
          conn.prepareStatement ("INSERT INTO COURSE(Course_Name, Course_Description, Course_Num, Semester_Hours, Lvl, Offering_Dep) " +
          "VALUES (?, ?, ?, ?, ?, ?)");
    int done = 1;
 
    while (done != 0) 
    {
try (Scanner scanner = new Scanner(System.in)) {
  try{
      System.out.println("\nEnter course name: ");
      System.out.println("Note: This information is required to proceed.");
      String coursename = scanner.nextLine();
      System.out.println("\nEnter course description: ");
      System.out.println("Or enter NULL if unavailable.");
      String coursedesc = scanner.nextLine();
      System.out.println("\nEnter course number: ");
      System.out.println("Format:AAA####");
      System.out.println("Or enter 0000000 if unavailable.");
      String coursenum = scanner.nextLine();   
      System.out.println("\nEnter semester hours: ");
      System.out.println("Or enter 0 if unavailable.");
      int semesterhrs = scanner.nextInt();
      System.out.println("\nEnter level: ");
      System.out.println("Or enter 0 if unavailable.");
      int lvl = scanner.nextInt();
      System.out.println("\nEnter offering department: ");
      System.out.println("Note: This information is required to proceed.");
      scanner.nextLine();
      String offeringdpt = scanner.nextLine();
      
 
      pstmt.setString(1, coursename);
      pstmt.setString(2, coursedesc);
      pstmt.setString(3, coursenum);
      pstmt.setInt(4, semesterhrs);
      pstmt.setInt(5, lvl);
      pstmt.setString(6, offeringdpt);
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
