import java.util.*;

public class Distance {
	
	int x,y;
	private Scanner s;
	
	public Distance() {
		
	}
	
	public void getDistance()
	{
		s = new Scanner(System.in);
		this.x=s.nextInt();
		this.y=s.nextInt();
	}
	
	public int distance(int x,int y)
	{
		int dist=(int)Math.sqrt((Math.pow((this.x-x),2)+Math.pow((this.y-y),2)));
		
		return dist;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Distance p1=new Distance();
		Distance p2=new Distance();
		
		p1.getDistance();
		p2.getDistance();
		
		int d=p1.distance(p2.x,p2.y);
		System.out.println(d);
		
	}

}
