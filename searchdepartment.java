import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class searchdepartment {
   
  public static void searchdeptmethod()
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
            conn.prepareStatement("SELECT Course_Name" + " FROM COURSE" + " WHERE Offering_Dep= ?");
        //  conn.prepareStatement("SELECT (Course_Name)" + "FROM COURSE" + "WHERE Offering_Dep=?");


    int done = 1;

    while (done != 0) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nFor which department would you like to see offered courses?");
              String courseselect = scanner.nextLine(); 
              pstmt.setString(1, courseselect);
              ResultSet rset = pstmt.executeQuery();

              while (rset.next ()) {
                String courses = rset.getString("Course_Name");  
                System.out.println("\nHere are all of the courses offered by the " + courseselect + " department.");    
                System.out.println (courses); 
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


      