import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class slashn {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		
		BufferedReader stop =new BufferedReader(new FileReader(args[0]));
		String stopline=new String();
		Pattern p=Pattern.compile("[^¡££¿£¡]+[¡££¿£¡]");
		Pattern q=Pattern.compile("\\S+/u?n");
		while((stopline=stop.readLine())!=null){
			//System.out.println(stopline);
			Matcher m=p.matcher(stopline);
			while(m.find()){
				int i=0;
				Matcher n=q.matcher(m.group());
				while(n.find()){
					i++;
					System.out.print(n.group()+"\t");
				}
				if(i!=0)
					System.out.println();
					
			}
		}
		
	}

}
