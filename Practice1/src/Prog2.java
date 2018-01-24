
public class Prog2 {

	public static void main(String[] args) {
		
		int n=Integer.parseInt(args[0]);
		
		int sum=0;
		while(n>0)
		{
			sum=sum+n%10;
			n=n/10;
		}
		
      System.out.println(sum);
	}

}
