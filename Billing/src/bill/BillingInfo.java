package bill;
import java.util.*;


public class BillingInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Admin objA=new Admin();
		User objC=new User();
		
		
		 /*boolean a=objA.authentication_Admin();
			if(a==true)
			{
				System.out.println("Authentication successful");
				objA.manageStoke();
			}
			else
			{
				System.out.println("Authentication failed");
			}
	}
}*/
		
		Scanner sc=new Scanner(System.in);
		while(true) 
		{
			try {
			//System.out.println("Are you Admin or Customer");
			System.out.println("Admin    Press :1");
			System.out.println("Custmer  Press :2");
			System.out.println("Exit     Press :3");
			
			
			
			int ch=sc.nextInt();
			switch(ch)
			  {
						case 1: boolean a=objA.authentication_Admin();
						if(a==true)
						{
							System.out.println("Authentication successful");
							objA.manageStoke();
						}
						else
						{
							System.out.println("Authentication failed");
						}
						break;
				
						case 2:objC.Purchase();
							System.out.println("Custumer");
						break;
				
						case 3: 
							    sc.close();
								System.out.println("Bye");
						        return;
						default:System.out.println("choose correct choice");
						break;
				}
		
		}catch(Exception e)
			{
			  System.out.println(e);
			}
		}
		
			
		}
		
		
   }



