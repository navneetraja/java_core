//check whether the number is odd or even;
//Take input from command line
import java.io.*;


public class Prog1 {

	public static  void main(String args[])
	{
		//String s=args[0];
		int n=Integer.parseInt(args[0]);
		if(n%2==0)
		 System.out.println("Even");
		else
			System.out.println("odd");
	}
}
