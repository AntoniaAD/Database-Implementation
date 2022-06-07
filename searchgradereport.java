import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class searchgradereport {
   
  public static void searchgradereportmethod()
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
            conn.prepareStatement("SELECT Gsemester, Gyear, Gcourse_num, Gsection_num, Grade" + " FROM GRADEREPORT" + " WHERE Gnnumber= ?");
        //  conn.prepareStatement("SELECT (Course_Name)" + "FROM COURSE" + "WHERE Offering_Dep=?");


    int done = 1;

    while (done != 0) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nEnter the Nnumber of the student whose grade report you would like to generate:");
              String grselect = scanner.nextLine(); 
              pstmt.setString(1, grselect);
              ResultSet rset = pstmt.executeQuery();

              while (rset.next ()) { 
                System.out.println("\nHere is the grade report for student " + grselect +":"); 
                System.out.print("Semester: ");
                String grstringsem = rset.getString("Gsemester");    
                System.out.println (grstringsem); 
                System.out.print("Year: ");
                String grstringyr = rset.getString("Gyear");    
                System.out.println (grstringyr); 
                System.out.print("Course Number: ");
                String grstringcn = rset.getString("Gcourse_num");    
                System.out.println (grstringcn); 
                System.out.print("Section: ");
                String grstringsecnum = rset.getString("Gsection_num");    
                System.out.println (grstringsecnum); 
                System.out.print("Letter Grade: ");
                String grstringgrd = rset.getString("Grade");    
                System.out.println (grstringgrd); 
                                }
      
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
    } // while done
  conn.close(); //Closes connection.

} // main

}  


      