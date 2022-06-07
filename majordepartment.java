import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class majordepartment {
   
    public static void majordeptmethod()
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
          conn.prepareStatement ("INSERT INTO MAJOR_DEPARTMENT(Dept_Code, OfficeNumber, OfficePhone) " +
          "VALUES (?, ?, ?)");
    int done = 1;
 
    while (done != 0) 
    {
try (Scanner scanner = new Scanner(System.in)) {
  try{
    System.out.println("\nEnter major's department code: ");
      String majdeptcode = scanner.nextLine();
      System.out.println("\nEnter major's office number: ");
      String majofficenum = scanner.nextLine();
      System.out.println("\nEnter major's office phone: ");
      Long majofficephone = scanner.nextLong();   
    
//may need to use variable other than string. need to see final sql to determine.
 
      pstmt.setString(1, majdeptcode);
      pstmt.setString(2, majofficenum);
      pstmt.setLong(3, majofficephone);
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
