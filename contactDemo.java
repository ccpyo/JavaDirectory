import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class contactDemo
{
	public static void main(String[] args)throws IOException
	{
		Scanner keyin = new Scanner(System.in);
		BufferedReader br=null;
	
		String line;
		int  data=0;
		
		cb[] a = new cb[129];
		for(int i=1;i<=128;i++)
			a[i] = new cb();
		contact.login();
		
		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream("contact.txt")));
			data=1;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("You don't have old data inside");
		}
		if(data==1)
		{
			System.out.println("Do you want to keep data inside?(Y/N)");
			String keep = keyin.next();
			if(keep.equalsIgnoreCase("Y"))
			{
				while((line=br.readLine()) != null)
				{
					StringTokenizer s = new StringTokenizer(line);
					String cname = s.nextToken().substring(5);
					String cbirthday = s.nextToken().substring(9);
					String cnumber = s.nextToken().substring(7);
					String cclassification = s.nextToken().substring(15);
					String cmail = s.nextToken().substring(7);
					a[contact.count_piece] = new cb(cname,cbirthday,cnumber,cclassification,cmail);
					contact.count_piece++;
				}
			}
		}
		
		
		FileWriter fw = new FileWriter("contact.txt");
		
		
		contact.choose(a);
		
		while(true)
		{
			System.out.print("Do you want to enter main manu?(Y/N)");
			String YN = keyin.next();
			
			if(YN.equalsIgnoreCase("Y"))
				contact.choose(a);
			else if(YN.equalsIgnoreCase("N"))
			{
				for(int i=1;i<=contact.count_piece-1;i++)
				{
					String c = "Name:"+a[i].contact_name +"  Birthday:" +a[i].contact_birthday + "  Number:" +a[i].contact_number + "  classification:" +a[i].contact_classification + "  E-mail:" +a[i].contact_mail +"\r\n";
					fw.write(c);
				}
				fw.close();
				
				contact.EXIT();
			}
			else
			{
				System.out.printf("Command not found. Choose again.\r\n");
			}
		}
	}
}