import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class grid_walk {
	/*public static class Point extends Point{
		public Point(Point p) {
			super(p);
			//this.x=p.x;
			//this.y=p.y;
			// TODO Auto-generated constructor stub
		}
		public Point(int i, int j) {
			super(i,j);
			// TODO Auto-generated constructor stub
		}
		
		public boolean equals(Object o){
			if(!(o instanceof Point))
				return false;
			Point tmp=(Point)o;
			return tmp.x==x&tmp.y==y;
		}
		public int hashcode(){
			int res=629+x;
			res=res*37+y;
			return res;
			
			
		}
	}
	*/
	public static boolean AvaPoint(Point p){
		int x=p.x;
		int y=p.y;
		int res=0;
		while(x!=0){
			res+=x%10;
			x/=10;
		}
		while(y!=0){
			res+=y%10;
			y/=10;
		}
		if(res<=19)
			return true;
		else
			return false;
	}
	public static int AroundPoint(Point p,Set<Point> set,ArrayList<Point> al){
		int ret=0;
		if(p.x*p.y>0){
			if(p.x>p.y)
				ret=15;
			else
				ret=6;
		}
		else{
			ret=13;
		}
		Point tmp=new Point(p);
		tmp.translate(0, 1);
		if(set.contains(tmp)||al.contains(tmp)||!AvaPoint(tmp))
			ret&=7;
		tmp.translate(1, -1);
		if(set.contains(tmp)||al.contains(tmp)||!AvaPoint(tmp))
			ret&=11;
		tmp.translate(-1, -1);
		if(set.contains(tmp)||al.contains(tmp)||!AvaPoint(tmp))
			ret&=13;
		tmp.translate(-1, 1);
		if(set.contains(tmp)||al.contains(tmp)||!AvaPoint(tmp))
			ret&=14;
		return ret;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Point> all=new HashSet<Point>();
		ArrayList<Point> now=new ArrayList<Point>();
		//all.add(new Point());
		now.add(new Point(1,0));
		all.add(new Point(0,0));
		int side=1;
		int time=0;
		while(now.size()!=0){
			time++;
			Point s=now.get(0);
			all.add(s);
			now.remove(0);
			if(s.x==s.y||s.y==0)
				side++;
			int tmp=AroundPoint(s,all,now);
			if((tmp|8)==tmp)
				now.add(new Point(s.x,s.y+1));
			if((tmp|4)==tmp)
				now.add(new Point(s.x+1,s.y));
			if((tmp|2)==tmp)
				now.add(new Point(s.x,s.y-1));
			if((tmp|1)==tmp)
				now.add(new Point(s.x-1,s.y));
			/*System.out.println(time+":");
			System.out.println();
			System.out.println();
			for(Point p:now){
				System.out.print("("+p.x+","+p.y+") ");
			}
			System.out.println();*/
		}
		//System.out.println(all.size());
		//System.out.println(side);
		int x8=all.size()-side;
		int x4=side-1;
		int res=x8*8+x4*4+1;
		System.out.println(res);
	}

}
