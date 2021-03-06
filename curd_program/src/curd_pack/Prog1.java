package curd_pack;

import java.sql.*;
import java.util.Scanner;
public class Prog1 {

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/register";

	   
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      
		   	Class.forName("com.mysql.jdbc.Driver");

	      
		   	System.out.println("Connecting to database...");
		   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   	String sql;
	      
	      
	      Scanner sc=new Scanner(System.in);
	      
	      int i=1;
	     while(i==1)
	     {
	    	 System.out.println("Enter 1 for Insert the Data");
	    	 System.out.println("Enter 2 for Delete the the Data");
	    	 System.out.println("Enter 3 for Update the Data");
	    	 System.out.println("Enter 4 for display the Data");
	    	 System.out.println("Enter 5 for exit");
	    	 System.out.println("choose your choice");
	    	 
	    	 int ch=sc.nextInt();
	    	 switch(ch)
	    	 {
	    	 	case 1:	try{
	    	 				System.out.println("Enter the data in the table");
	    	           	
	    	 				stmt = conn.createStatement();
	    	 				int id=sc.nextInt();
	    	 				String fname=sc.next();
	    	 				String emailId=sc.next();

	    	 				sql = "INSERT INTO user VALUES ('"+id +"','"+fname +"','"+ emailId +"')";
	    	            	stmt.executeUpdate(sql);
	    	            	System.out.println("Records has inserted  into the table");
	    	            	}
	    	            catch(Exception e){
	    	            	System.out.println(e);
	    	            	}
	    	 				
	    	 				break;
	    	            
	    	    case 2:try{
	    	    		   System.out.println("Delete the data");
	    	    		   System.out.println("Enter the id which you have to delete");
	    	    		   int d=sc.nextInt();
	            		
	    	    		   //System.out.println("Creating statement...");
	    	    		   stmt = conn.createStatement();
	    	    		   sql = "DELETE FROM user " + "WHERE uid = "+ d +"";
	    	    		   System.out.println("Record is deleted from database");
	    	    		   stmt.executeUpdate(sql);
	            	     }
	    	           catch(Exception e){
	    	        	   
	    	        	   System.out.println(e);
	    	           	 }
	    	    		break;
	            	      
	    	   case 3:try{
	    		           System.out.println("Enter the id which you have to update");
	    		           int upid=sc.nextInt();
	    		           String uname=sc.next();
	    		           String uemail=sc.next();
	    		           
	    		           stmt = conn.createStatement();
	    	    			
	    	    			sql = "UPDATE user SET name='"+uname+"',email='"+uemail+"' WHERE uid='"+upid+"'";
	    	    			stmt.executeUpdate(sql);
	    	   			}
	    	   		catch(Exception e){
	    	   			   System.out.println(e);
	    	   			
	    	   			}				
	    	   			break;
	    	    case 4:try {
	    	    	    System.out.println("Display the data");
	    	    	   														//System.out.println("Creating statement...");
	    	    		stmt = conn.createStatement();
	    	    			                                                //selecting data from thhe table
	    	    		sql = "SELECT * FROM user";
	    	    		ResultSet rs = stmt.executeQuery(sql);

	    	    													        //STEP 5: Extract data from result set
	    	    		while(rs.next()){
	    	    															//Retrieve by column name
	    	    		int uid  = rs.getInt("uid");
	    	    		String name = rs.getString("name");
	    	    		String email = rs.getString("email");

	    	    															//Display values
	  	         		System.out.println("uid: "+ uid);
	  	         		System.out.println("NAME: " + name);
	  	         		System.out.println("Email: " + email);
	    	    			}
	    	      }
	    	    catch(Exception e)
	    	    {
	    	         System.out.println(e);	
	    	    }
	  	         		break;
	    	    case 5: i=0;
        				break;
        		default: System.out.println("Please choode the correct option");	
        		          break;
	    	  }
	    	    
	    	 }
	 	   
	   }catch(Exception e){
		   																		//Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
		   																	    //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }																		// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }																			//end finally try
	   }																			//end try
	   System.out.println("Goodbye!");
	}																				//end main
	}																				//end FirstExample