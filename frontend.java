import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
//import java.sql.*;
//import java.io.*;  


public class frontend {

	public static void main(String[] args) throws SQLException {

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
        try {
			Connection conn = DriverManager.getConnection(url, username, password);
			
	        boolean reachable = conn.isValid(10);// 10 sec

	        if(reachable) {
	        	//Tells the user they've connected.
	        	System.out.println("You have successfully connected to the database.");
	        	conn.close(); //Closes connection. //!! Consider removing this and not having to connect again
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try (Scanner sori = new Scanner(System.in)) {
			System.out.println("\nWould you like to search the database or insert data?");
			System.out.println("\n Enter 1 to Insert.");
			System.out.println("\n Enter 2 to Search.");
			String selectoperation = sori.nextLine();
			System.out.println("You chose: "+ selectoperation);
			if (selectoperation.equals("1")) {
				System.out.println("You chose to insert data.");
        try (Scanner selectinsert=new Scanner(System.in)) {
        System.out.println("\n Would you like to insert a:");
        System.out.println("\n Student? Enter 1");
        System.out.println("\n Department? Enter 2");
        System.out.println("\n Course? Enter 3");
        System.out.println("\n Course section? Enter 4");
		System.out.println("\n Grade report? Enter 5");
          String insertions= selectinsert.nextLine();
          if (insertions.equals("1")) {
            System.out.println("\n You have chosen Student.");
			try {
				student.studentmethod();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            //call student
          }
         else if (insertions.equals("2")){
               System.out.println("\n You have chosen Department."); //TODO address method for minor.
			   try {
				department.deptmethod();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
          }
          else if (insertions.equals("3")){
               System.out.println("\n You have chosen Course.");
			   try {
				course.coursemethod();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //call department
          }
          else if (insertions.equals("4")) {
               System.out.println("\n You have chosen Section.");
			   try {
				coursesection.coursesectmethod();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //call section
          }
		  else if (insertions.equals("5")) {
			System.out.println("\n You have chosen Grade Report.");
			try {
			 gradereport.gradereportmethod();
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 //call section
	   }
          else {
            System.out.println("\n Invalid input.");
			
          }
          }
        
        
			}
			else if (selectoperation.equals("2")) {
				System.out.println("You chose to search for data.");
				System.out.println("\nEnter 1 if you would like to search a department's courses.");
				System.out.println("Enter 2 if you would like to generate a grade report for a student.");
				try (Scanner selectsearch=new Scanner(System.in)) {
				 
				String searches= selectsearch.nextLine();
          if (searches.equals("1")) {
			System.out.println("\n You have chosen to search for courses.");

				searchdepartment.searchdeptmethod();
		  }
		  else if (searches.equals("2")){
			System.out.println("\n You have chosen to search for grades.");
			searchgradereport.searchgradereportmethod();
		  }

		  }
			}
		
			else {
				System.out.println("Your input was invalid");
			}
		}
		}
	}



	
	

        


