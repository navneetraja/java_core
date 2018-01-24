package bill;
import java.sql.*;

import java.util.*;
//import java.util.Scanner;


public class Admin {
	
	
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost/billing";

	   
	   static final String USER = "root";
	   static final String PASS = "";
	
	   Connection conn = null;
	   Statement stmt = null;
	   
	   Scanner sc=new Scanner(System.in);
	   
	  
	   
	   public boolean  authentication_Admin()
	   {
		
		   try{
			   	Class.forName("com.mysql.jdbc.Driver");
			   	System.out.println("Connecting to database...");
			   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   	stmt = conn.createStatement();
		   
			   	//Scanner sc=new Scanner(System.in);
			   	System.out.println("Enter username");
			   	String username=sc.next();
			   	System.out.println("Enter password");
			   	String password=sc.next();
		   
			   	String sql ="select password from admins where username=\""+username+"\"";
			   	
			   	ResultSet rs = stmt.executeQuery(sql);
			   	//sc.close();
			   	

			   	if(!rs.next())
			   	{
			   		System.out.println("Nanveet you are wrong\ns");
			   		return false;
			   	}
			   	else
			   	{
			   		if(rs.getString("password").equals(password))
			   		{
			   		    return true;
			   		}
			   		else
			   		{
			   			return false;
			   		}
			   	}
			   	
		   	}catch(Exception e) {
		   		System.out.println(e);
		   		return false;
		   	}finally {
		   		
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
		   			}			
		   		
		   	}
	   }
	   
	   public void manageStoke()
	   {
		   try {
				Class.forName("com.mysql.jdbc.Driver");
			   	System.out.println("Connecting to database...");
			   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   	//stmt = conn.createStatement();
		   
		   
		   while(true)
		   {
				//Scanner sc=new Scanner(System.in);
			   
			   	
			     System.out.println("\n\nInsert the Item      Press:1");
		    	 System.out.println("Delete the the Item  Press:2");
		    	 System.out.println("Update the Data      Press:3");
		    	 System.out.println("Display the Item     Press:4");
		    	 System.out.println("Exit                 Press:5");
		    	 System.out.println("Enter your choice");
		    	 
		    	 int ch=sc.nextInt();
		    	 switch(ch)
		    	 {
		    	 	case 1:	try{
		    	 				System.out.println("Enter the item in the table");
		    	           	
		    	 				stmt = conn.createStatement();
		    	 				System.out.println("Enter the name of the food");
		    	 				String item_name=sc.next();
		    	 				System.out.println("Enter the price");
		    	 				int item_price=sc.nextInt();
		    	 				System.out.println("Enter the Quantity");
		    	 				int item_stock=sc.nextInt();

		    	 				String sql = "INSERT INTO stock(item_name,item_price,item_stock) VALUES ('"+item_name +"','"+item_price +"','"+ item_stock +"')";
		    	            	stmt.executeUpdate(sql);
		    	            	System.out.println("Records has inserted  into the table");
		    	            	}
		    	            catch(Exception e){
		    	            	System.out.println(e);
		    	            	}
		    	 				
		    	 				break;
		    	 	 case 2:try{
		    	 		 		System.out.println("Enter the id which you have to delete");
		    	 		 		int d=sc.nextInt();
	            		
		    	 		 		//System.out.println("Creating statement...");
		    	 		 		stmt = conn.createStatement();
		    	 		 		String sql = "DELETE FROM stock " + "WHERE item_id = "+ d +"";
		    	 		 		System.out.println("Record is deleted from database");
		    	 		 		stmt.executeUpdate(sql);
		    	 	 		   }
	    	           	  catch(Exception e){
	    	        	   
	    	        	   		System.out.println(e);
	    	           		  }
	    	    			  break;
		    	 	case 3:try{
	    		           	   System.out.println("Enter the id which you have to update");
	    		           	 
	    		           	   int item_id=sc.nextInt();
	    		           	   
	    		           	   System.out.println("Enter the item which you have to update in the stock");
	    		           	   System.out.println("Enter the name of the food");
	    		           	   String item_name=sc.next();
	    		           	   System.out.println("Enter the price of the food");
	    		           	   int item_price=sc.nextInt();
	    		           	   System.out.println("Enter the quantity of the food");
	    		           	   int item_stock=sc.nextInt();
	    		           
	    		           	   stmt = conn.createStatement();
	    	    			    
	    		           	
	    		           	   String sql = "UPDATE stock SET item_name='"+item_name+"',item_price='"+item_price+"',item_stock='"+item_stock+"' WHERE item_id='"+item_id+"'";
	    		           	   stmt.executeUpdate(sql);
	    		           	   System.out.println("Stock has updated successfully");
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
		    		 		 String sql = "SELECT * FROM stock";
		    		 		 ResultSet rs = stmt.executeQuery(sql);

	    	    													        //STEP 5: Extract data from result set
		    		 		System.out.println("ID \t"+"NAME of Food \t"+"Price \t"+"Stock");
		    		 		System.out.println("==========================================="); 
		    		 		 while(rs.next()){
	    	    															//Retrieve by column name
		    		 		int item_id  = rs.getInt("item_id");
		    		 		String item_name = rs.getString("item_name");
		    		 		int item_price = rs.getInt("item_price");
		    		 		int item_stock = rs.getInt("item_stock");

	    	    															//Display values
		    		 		//System.out.println("ID \t"+"NAME of Food \t"+"Price \t"+"Stock");
		    		 		//System.out.println("==========================================="); 
		    				System.out.println(item_id+"\t"+item_name+"\t\t"+item_price+"\t"+item_stock); 
		    				
		    		 		
		    		 		
		    		 		/*System.out.println("ID:            "+ item_id);
		    		 	    System.out.println("NAME of Food: " + item_name);
		    		 	    System.out.println("Price:        " + item_price);
		    		 	    System.out.println("Stock:         " + item_stock);*/
	    	    			}
	    	      }
	    	    catch(Exception e)
	    	    {
	    	         System.out.println(e);	
	    	    }
	  	         		break;
	    	    case 5:
	    	    	   //sc.close();
     				    return;			  
		    	 	default:System.out.println("choose correct choice");			
		    	 }
		   
		   }
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }finally {
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
			   			  }			
		   }
	   } 
	   
}
	   
