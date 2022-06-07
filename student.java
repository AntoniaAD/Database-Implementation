import java.sql.*;
//import java.io.*;  
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class student {
   
  public static void studentmethod()
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
          conn.prepareStatement ("INSERT INTO STUDENT(Nnumber, Ssn, Caddress, Cphone, Pphone, Bdate, Sex, Gclass, Major_dep, Minor_dep, Degree_prm, Fname, Mname, Lname, City, Cstate, Zip) " +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    int done = 1;
 
    while (done != 0) 
    {
try (Scanner scanner = new Scanner(System.in)) {
  try{
    System.out.println("\nEnter student's N-number: ");
    System.out.println("Format: N########");
    System.out.println("Note: This information is required to proceed.");
      String Nnumber = scanner.nextLine();
      System.out.println("\nEnter student's social security number: ");
      System.out.println("Format: AAA-GG-SSSS");
      System.out.println("Note: This information is required to proceed.");
      String Ssn = scanner.nextLine();
      System.out.println("\nEnter student's current address: ");
      System.out.println("Or enter NULL if unavailable.");
      String Caddress = scanner.nextLine();   
      System.out.println("\nEnter student's current phone number: ");
      System.out.println("Format: ###-###-####");
      System.out.println("Or enter 000-000-0000 if unavailable.");
      String Cphone = scanner.nextLine();
      System.out.println("\nEnter student's permanent phone number: ");
      System.out.println("Format: ###-###-####");
      System.out.println("Or enter 000-000-0000 if unavailable.");
      String Pphone = scanner.nextLine();
      System.out.println("\nEnter student's birth date: ");
      System.out.println("Format: MM-DD-YYYY");
      System.out.println("Or enter 00-00-0000 if unavailable.");
      String Bdate = scanner.nextLine(); 
      System.out.println("\nEnter student's sex: ");
      System.out.println("Or enter NULL if unavailable.");
      String Sex = scanner.nextLine();
      System.out.println("\nEnter student's class standing (Freshman, Sophomore, Junior, Senior, or Graduate): ");
      System.out.println("Or enter NULL if unavailable.");
      String Gclass = scanner.nextLine(); 
      System.out.println("\nEnter the department of the student's major: ");
      System.out.println("Or enter NULL if unavailable.");
      String Majordept = scanner.nextLine();
      System.out.println("\nEnter the department of the student's minor: ");
      System.out.println("Or enter NULL if unavailable.");
      String Minordept = scanner.nextLine();
      System.out.println("\nEnter the student's degree program (BS, BA, PHD, etc.): ");
      System.out.println("Or enter NULL if unavailable.");
      String Degreeprm = scanner.nextLine();
      System.out.println("\nEnter the student's first name: ");
      System.out.println("Or enter NULL if unavailable.");
      String Fname = scanner.nextLine();
      System.out.println("\nEnter the student's middle initial: ");
      System.out.println("Or enter NULL if unavailable.");
      String Mname = scanner.nextLine();
      System.out.println("\nEnter the student's last name: ");
      System.out.println("Or enter NULL if unavailable.");
      String Lname = scanner.nextLine();
      System.out.println("\nEnter the city of the student's PERMANENT address: ");
      System.out.println("Or enter NULL if unavailable.");
      String City = scanner.nextLine();
      System.out.println("\nEnter the state of the student's PERMANENT address: ");
      System.out.println("Format: FL, GA.");
      System.out.println("Or enter 00 if unavailable.");
      String State = scanner.nextLine();
      System.out.println("\nEnter the ZIP code of the student's PERMANENT address: ");
      System.out.println("Format: #####.");
      System.out.println("Or enter 00000 if unavailable.");
      String Zip = scanner.nextLine();
 
      pstmt.setString(1, Nnumber);
      pstmt.setString(2, Ssn);
      pstmt.setString(3, Caddress);
      pstmt.setString(4, Cphone);
      pstmt.setString(5, Pphone);
      pstmt.setString(6, Bdate); 
      pstmt.setString(7, Sex);
      pstmt.setString(8, Gclass);
      pstmt.setString(9, Majordept);
      pstmt.setString(10, Minordept);
      pstmt.setString(11, Degreeprm);
      pstmt.setString(12, Fname);
      pstmt.setString(13, Mname);
      pstmt.setString(14, Lname);
      pstmt.setString(15, City);
      pstmt.setString(16, State);
      pstmt.setString(17, Zip);

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
