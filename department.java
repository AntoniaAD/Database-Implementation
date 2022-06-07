import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class department {
   
    public static void deptmethod()
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
          conn.prepareStatement ("INSERT INTO DEPARTMENT(OfficeName, Dept_Code, OfficeNumber, OfficePhone) " +
          "VALUES (?, ?, ?, ?)");
    int done = 1;
 
    while (done != 0) 
    {
try (Scanner scanner = new Scanner(System.in)) {
  try {
    System.out.println("\nEnter department name: ");
    System.out.println("Note: This information is required to proceed.");
      String deptname = scanner.nextLine();
      System.out.println("\nEnter department code: ");
      System.out.println("The code should be no more than 4 characters");
      System.out.println("Note: This information is required to proceed.");
      String deptcode = scanner.nextLine();
      System.out.println("\nEnter department's office number: ");
      System.out.println("The office number should be 4 digits.");
      System.out.println("Or enter NULL if unavailable.");
      String officenum = scanner.nextLine();   
      System.out.println("\nEnter department's office phone: ");
      System.out.println("Format: ###-###-####");
      System.out.println("Or enter 000-000-0000 if unavailable.");
      String officephone = scanner.nextLine();  
//may need to use variable other than string. need to see final sql to determine.
 //add name insert
      pstmt.setString(1, deptname);
      pstmt.setString(2, deptcode);
      pstmt.setString(3, officenum);
      pstmt.setString(4, officephone);
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
             System.out.println("You chose to insert data.");
            frontend.main(null);
           }
           }
    
          }
      } // while done
    conn.close(); //Closes connection.
 
  } // main
 
}  
