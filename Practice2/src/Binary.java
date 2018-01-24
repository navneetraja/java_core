
public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int n=Integer.parseInt(args[0]);
         int binary=0;
         int rem=1;
         int place=1;
        
         while(n>0) {
         rem = n % 2;

         binary = (rem * place) + binary;

         n=n/ 2;

         place *= 10;
         }
         System.out.println(binary);
	}
}
