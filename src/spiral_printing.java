import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class spiral_printing {

	public static void onion(int m,int n,String[][] a,int time,boolean start){
		int mprime=m-2*time;
		int nprime=n-2*time;
		if(mprime*nprime==0){
			System.out.println();
			return;
		}
		if(!start)
			System.out.print(" ");
		if(mprime==1){
			int mid=m/2;
			int end=n-time-1;
			for(int i=mid;i<end;i++){
				System.out.print(a[mid][i]+" ");
			}
			System.out.println(a[mid][end]);
			return;
		}
		if(nprime==1){
			int mid=n/2;
			int end=m-time-1;
			for(int i=mid;i<end;i++){
				System.out.print(a[i][mid]+" ");
			}
			System.out.println(a[end][mid]);
			return;
		}
		for(int i=time;i<n-time-1;i++){
			System.out.print(a[time][i]+" ");
		}
		for(int i=time;i<m-time-1;i++){
			System.out.print(a[i][n-time-1]+" ");
		}
		for(int i=n-time-1;i>time;i--){
			System.out.print(a[m-time-1][i]+" ");
		}
		for(int i=m-time-1;i>time+1;i--){
			System.out.print(a[i][time]+" ");
		}
		System.out.print(a[time+1][time]);
		onion(m,n,a,time+1,false);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(args[0]));
		String input;
		while((input=br.readLine())!=null){
			input=input.trim();
			String[] s3=input.split(";");
			int m=Integer.parseInt(s3[0]);
			int n=Integer.parseInt(s3[1]);
			int size=m*n;
			String[][] a=new String[m][n];
			String[] tmp=s3[2].split(" ");
			int i=0;
			int j=0;
			
			for(String s:tmp){
				a[i][j++]=s;
				if(j==n){
					j=0;
					i++;
				}
			}
			

			onion(m,n,a,0,true);
		}
		br.close();
		return;
	}

}
