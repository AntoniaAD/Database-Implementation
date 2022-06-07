import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class gradereport{
   
    public static void gradereportmethod()
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
          conn.prepareStatement ("INSERT INTO GRADEREPORT(Gnnumber, Gsemester, Gyear, Gcourse_num, Gsection_num, Grade) " +
          "VALUES (?, ?, ?, ?, ?, ?)");
    int done = 1;
 
    while (done != 0) 
    {
try (Scanner scanner = new Scanner(System.in)) {
  try {
    System.out.println("\nEnter the Nnumber of the student whose grades you would like to insert: ");
    System.out.println("Format: N########");
    System.out.println("Note: This information is required to proceed.");
      String grnumber= scanner.nextLine();
      System.out.println("\nEnter the semester for the student's grade:");
      System.out.println("Note: This information is required to proceed.");
      String grsemester = scanner.nextLine();
      System.out.println("\nEnter the year for the student's grade: ");
      System.out.println("Note: This information is required to proceed.");
      int gryear = scanner.nextInt();   
      System.out.println("\nEnter the course number for the student's grade: ");
      System.out.println("Format:AAA####");
      System.out.println("Note: This information is required to proceed.");
      scanner.nextLine();
      String grcoursenum = scanner.nextLine();  
      System.out.println("\nEnter the section number for the student's grade: ");
      System.out.println("Note: This information is required to proceed.");
      String grsecnum = scanner.nextLine();  
      System.out.println("\nEnter the student's letter grade:");
      System.out.println("Standard Grades: A, B, C, D, F.");
      System.out.println("Other Grades: NR, X, I, P, S, U, FA, WC, WM, WS and WD.");
      System.out.println("Note: This information is required to proceed.");
      String grgrade = scanner.nextLine();  
//may need to use variable other than string. need to see final sql to determine.
 //add name insert
      pstmt.setString(1, grnumber);
      pstmt.setString(2, grsemester);
      pstmt.setInt(3, gryear);
      pstmt.setString(4, grcoursenum);
      pstmt.setString(5,grsecnum);
      pstmt.setString(6,grgrade);
  }
  finally {
      int NumRows = pstmt.executeUpdate();
      System.out.println("\n" + NumRows + " row(s) inserted");
 
      
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
      } 
    conn.close(); 
 
  } 
 
}  
