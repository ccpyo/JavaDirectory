import java.io.*;
import java.util.*;

public class contact
{
	public static int count_piece=1;
	public static boolean check(String account,String password)
	{
		if(!account.equals("cis"))
		{
			System.out.print("Wrong username. ");
			return false;
		}
		if(!password.equals("1234"))
		{
			System.out.print("Wrong password. ");
			return false;
		}
		return true;
	}
	
	public static void login()
	{
		String account,password;
		Scanner keyin = new Scanner(System.in);
		System.out.printf("Username:"); account=keyin.next(); System.out.println();
		System.out.printf("Password:"); password=keyin.next(); System.out.println();
		
		while(!contact.check(account,password))
		{
			System.out.print("Try again\r\n");
			System.out.printf("Username:"); account=keyin.next(); System.out.println();
			System.out.printf("Password:"); password=keyin.next(); System.out.println();
		}
		
		
	}
	
	public static void choose(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		int func;
		System.out.println("Leave: 0  User mode: 1  Manage mode: 2");
		func = keyin.nextInt();
		
		switch(func)
		{
			case 1 : user(a); break;
			case 2 : admin(a); break;
			case 0 : break;
			default :System.out.printf("Command not found.\r\n"); choose(a); break;
		}
	}
	
	public static void admin(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Please choose which function you want.");
		System.out.println("0 Back to previous level.");
		System.out.println("1 Display all data.");
		System.out.println("2 Display data by classification.");
		System.out.println("3 Rearrange all data.");
		int adminfunc = keyin.nextInt();
		
		switch (adminfunc)
		{
			case 0 : choose(a); break;
			case 1 : Admin_Display_All(a); break;
			case 2 : Admin_Display_classification(a); break;
			case 3 : Admin_Rearrange(a); break;
			default :System.out.printf("Command not found.\r\n"); choose(a); break;
		}
	}
	
	public static void Admin_Display_All(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Choose the display mode by which order.");
		System.out.println("1 Ascending");
		System.out.println("2 Descending");
		int order = keyin.nextInt();
		
		switch(order)
		{
			case 1 :
		/*	for(int i=1;i<=count_piece;i++)
			{
				for(int p=0;p<=a[i].contact_name.length();p++)
				{
					if(a[i].contact_name.charAt(p)>a[i+1].contact_name.charAt(p))
					{
						String t_name = a[i].contact_name, t_birthday = a[i].contact_birthday, t_number=a[i].contact_number, t_claddification = a[i].contact_classification, t_mail = a[i].contact_mail;
						a[i].contact_name = a[i+1].contact_name; a[i].contact_birthday = a[i+1].contact_birthday; a[i].contact_number = a[i+1].contact_number; a[i].contact_classification = a[i+1].contact_classification; a[i].contact_mail = a[i+1].contact_mail;
						a[i+1].contact_name = t_name; a[i].contact_birthday = t_birthday; a[i].contact_number = t_number; a[i].contact_classification = t_claddification; a[i].contact_mail = t_mail;
					}
				}
			}*/ break;
			case 2 :
		/*	for(int i=1;i<=contact.count_piece;i++)
			{
				for(int p=0;p<=a[i].contact_name.length();p++)
				{
					if(a[i].contact_name.charAt(p)<a[i+1].contact_name.charAt(p))
					{
						String t_name = a[i].contact_name, t_birthday = a[i].contact_birthday, t_number=a[i].contact_number, t_claddification = a[i].contact_classification, t_mail = a[i].contact_mail;
						a[i].contact_name = a[i+1].contact_name; a[i].contact_birthday = a[i+1].contact_birthday; a[i].contact_number = a[i+1].contact_number; a[i].contact_classification = a[i+1].contact_classification; a[i].contact_mail = a[i+1].contact_mail;
						a[i+1].contact_name = t_name; a[i].contact_birthday = t_birthday; a[i].contact_number = t_number; a[i].contact_classification = t_claddification; a[i].contact_mail = t_mail;
					}
				}
			}*/ break;
			default :System.out.printf("Command not found.\r\n"); Admin_Display_All(a); break;
		}
	}
	
	public static void Admin_Display_classification(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
	}
	
	public static void Admin_Rearrange(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
	}
	
	public static void user(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Please choose which function you want.");
		System.out.println("Back to previous level please input 0");
		System.out.println("Add new data please input 1");
		System.out.println("Display all data please input 2");
		System.out.println("Display classification please input 3");
		System.out.println("Search data please input 4");
		System.out.println("Modify data please input 5");
		System.out.println("Delete data please input 6");
		int func = keyin.nextInt();
		
		switch (func)
		{
			case 0 : choose(a); break;
			case 1 : Add(a); break;
			case 2 : Display_All(a); break;
			case 3 : Display_classification(a); break;
			case 4 : Search(a); break;
			case 5 : Modify(a); break;
			case 6 : Delete(a); break;
			default :System.out.printf("Command not found.\r\n"); choose(a); break;
		}
	}
	
	public static void Add(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.print("Input the piece of data you want to add:");
		int piece = keyin.nextInt();
		for(int i=count_piece;i<=piece;count_piece++,i++)
		{
			System.out.print("Name:");				String name = keyin.next();
			
			while(!cb.checkname(name)) //check name
			{
				System.out.println("Wrong format,please input again."); 
				name = keyin.next();
			}	System.out.println();
			
			System.out.print("Birthday(MMDD):");	String birthday = keyin.next();			
			
			while(!cb.checkbirthday(birthday)) //check birthday
			{
				System.out.println("Wrong format,please input again."); 
				birthday = keyin.next();
			}	System.out.println();
			
			
			System.out.print("Phone number:");		String number = keyin.next();			
			
			while(!cb.checkphone(number)) //check phonenumber
			{
				System.out.println("Wrong format,please input again."); 
				number = keyin.next();
			}	System.out.println();
			
			
			System.out.print("Classification:");	String classification = keyin.next();	
			
			while(!cb.checkclassification(classification)) //check classification
			{
				System.out.println("Wrong format,please input again."); 
				classification = keyin.next();
			}	System.out.println();
			
			
			System.out.print("E-mail:");			String mail = keyin.next();				
			
			while(!mail.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) //check MAIL
			{
				System.out.println("Wrong format,please input again."); 
				mail = keyin.next();
			}	System.out.println();
			
			
			a[i].setcb(name,birthday,number,classification,mail);
		}
	}
	
	public static void Display_All(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("How many piece of data you want to display each page?(0 = all data)");
		int DisPiece = keyin.nextInt();
		if(DisPiece>0 && DisPiece<=128)
		{
			int v=1;
			for(int w=1;(w*DisPiece)<(count_piece + DisPiece - 1);w++) //Display page
			{
				for(int i=v;i<=w*DisPiece;i++)
				{
					if(a[i].contact_name != null)
					System.out.println("Name:"+a[i].contact_name +" Birthday:" +a[i].contact_birthday + " Number:" +a[i].contact_number + "  classification:" +a[i].contact_classification + "  E-mail:" +a[i].contact_mail);
					else
					System.out.println("There's no data below.");
					
				}
				System.out.println("\nInput Y to next page.");
				String page = keyin.next();
				
				
				
				v=v+DisPiece;
			}
		}
		else if(DisPiece==0)
		{
			for(int i=1;i<=count_piece-1;i++)
		{
			System.out.println("Name:"+a[i].contact_name +" Birthday:" +a[i].contact_birthday + " Number:" +a[i].contact_classification + " E-mail" +a[i].contact_mail);
		}
		}
		else
		{
			System.out.println("Wrong piece you input,back to user mode\r\n");
			user(a);
		}
	}
	
	public static void Display_classification(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Input the classification you want to display");
		String c_classification = keyin.next();
		for(int i=1;i<=count_piece;i++)
		{
			if(c_classification.equals(a[i].contact_classification))
			{
				System.out.println("Name:"+a[i].contact_name +" Birthday:" +a[i].contact_birthday + " Number:" +a[i].contact_number + "  classification:" +a[i].contact_classification + "  E-mail:" +a[i].contact_mail);
			}
		}
	}
	
	public static void Search(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("0. Back to previous level ");
		System.out.println("1. By name ");
		System.out.println("2. By number ");
		int s_c = keyin.nextInt();
		
		switch(s_c)
		{
			case 0 : user(a); break;
			case 1 : search_name(a); break;
			case 2 : search_number(a); break;
			default : System.out.printf("Command not found."); choose(a); break;
		}

	}
	
	public static void search_name(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Input the name you want to display");
		String c_name = keyin.next();
		for(int i=1;i<=count_piece;i++)
		{
			if(c_name.equals(a[i].contact_name))
			{
				System.out.println("Name:"+a[i].contact_name +" Birthday:" +a[i].contact_birthday + " Number:" +a[i].contact_number + " classification:"+a[i].contact_classification + " E-mail:" +a[i].contact_mail);
			}
		}
	}
	
	public static void search_number(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Input the number you want to display");
		String c_number = keyin.next();
		for(int i=1;i<=count_piece;i++)
		{
			if(c_number.equals(a[i].contact_number))
			{
				System.out.println("Name:"+a[i].contact_name +" Birthday:" +a[i].contact_birthday + " Number:" +a[i].contact_number + " classification:"+a[i].contact_classification + " E-mail:" +a[i].contact_mail);
			}
		}
	}
	
	public static void Modify(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Input the name you want to modify");
		String c_name = keyin.next();
		for(int i=1;i<=count_piece;i++)
		{
			if(c_name.equals(a[i].contact_name))
			{
				System.out.print("Name:");				String name = keyin.next();
			
				while(!cb.checkname(name)) //check name
				{
					System.out.println("Wrong format,please input again."); 
					name = keyin.next();
				}		System.out.println();
			
				System.out.print("Birthday(MMDD):");	String birthday = keyin.next();			
			
				while(!cb.checkbirthday(birthday)) //check birthday
				{
					System.out.println("Wrong format,please input again."); 
					birthday = keyin.next();
				}	System.out.println();
			
			
				System.out.print("Phone number:");		String number = keyin.next();			
			
				while(!cb.checkphone(number)) //check phonenumber
				{
					System.out.println("Wrong format,please input again."); 
					number = keyin.next();
				}	System.out.println();
			
			
				System.out.print("Classification:");	String classification = keyin.next();	
			
				while(!cb.checkclassification(classification)) //check classification
				{
					System.out.println("Wrong format,please input again."); 
					classification = keyin.next();
				}	System.out.println();
			
			
				System.out.print("E-mail:");			String mail = keyin.next();				
			
				while(!mail.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) //check MAIL
				{
					System.out.println("Wrong format,please input again."); 
					mail = keyin.next();
				}	System.out.println();
				a[i].setcb(name,birthday,number,classification,mail);
			}
		}
	}
	
	public static void Delete(cb[] a)
	{
		Scanner keyin = new Scanner(System.in);
		System.out.println("Input the name you want to delete");
		String c_name = keyin.next();
		for(int i=1;i<=count_piece;i++)
		{
			if(c_name.equals(a[i].contact_name))
			{
				for(int z=i;z<=count_piece;i++,z++)
				{
					a[i]=a[i+1];
				}
			}
		}
	}
	
	public static void EXIT()
	{
		System.exit(0);
	}
}