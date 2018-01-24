import java.util.Scanner;

public class Sumdigit {

	

	private static Scanner sc;

	public static void main(String[] args) {
		
		//int n=Integer.parseInt(args[0]);
		
		sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int sum=0;
		while(n>0)
		{
			sum=sum+n%10;
			n=n/10;
		}
		
      System.out.println(sum);
	}

}


