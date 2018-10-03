public class cb
{
	public String contact_name;
	public String contact_birthday;
	public String contact_number;
	public String contact_classification;
	public String contact_mail;
	
	public cb(String cname,String cbirthday,String cnumber,String cclassification,String cmail)
	{
			setcb(cname,cbirthday,cnumber,cclassification,cmail);
	}
	public cb(){}
	public void setcb(String cname,String cbirthday,String cnumber,String cclassification,String cmail)
	{
		this.contact_name=cname;
		this.contact_birthday=cbirthday;
		this.contact_number=cnumber;
		this.contact_classification=cclassification;
		this.contact_mail=cmail;
	}

	public static boolean checkphone(String number)
	{
		int nl=number.length();
		 if(nl==10)
		 {
			 if(number.matches("[0-9]{10}"))
				 return true;
			 else
				 return false;
		 }
         else if(nl==11)
         {
			 if(number.matches("[(]{1}[0-9]{2}[)]{1}[0-9]{7}"))
				 return true;
			 else
				 return false;
		 }
		 else if(nl==12)
         {
			 if(number.matches("[(]{1}[0-9]{2}[)]{1}[0-9]{8}"))
				 return true;
			 else
				 return false;
		 }
		 else
			 return false; 	
	}
	
	public static boolean checkname(String name)
	{
		for(int x=0;x<name.length();x++)
		{
			if(!Character.isLetter(name.charAt(x)))
				return false;
		}
		return true;
	}
	
	public static boolean checkclassification(String classification)
	{
		for(int x=0;x<classification.length();x++)
		{
			if(!Character.isLetter(classification.charAt(x)))
				return false;
		}
		return true;
	}
	
	public static boolean checkbirthday(String birthday)
	{	
		if(birthday.length()==4)
		{	
			for(int x=0;x<birthday.length();x++)
			{
				if(!Character.isDigit(birthday.charAt(x)))
					return false;
			}
			int month=Integer.parseInt(birthday.substring(0,2));
			int day = Integer.parseInt(birthday.substring(2,4));
			if(month>0 && month<=12 && day>0 && day<=31)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
/*	public static void Acsend_name(String a[i].contact_name,String a[i].contact_birthday,String a[i].contact_number,String a[i].contact_classification,String a[i].contact_mail)
	{
		for(int i=1;i<=contact.count_piece;i++)
		{
			for(int p=0;p<=a[i].contact_name.length();p++)
			{
				if(a[i].contact_name.charAt(p)>a[i+1].contact_name.charAt(p))
				{
					String t_name = a[i].contact_name, t_birthday = a[i].contact_birthday, t_number=a[i].contact_number, t_claddification = a[i].contact_classification, t_mail = a[i].contact_mail;
					a[i].contact_name = a[i+1].contact_name, a[i].contact_birthday = a[i+1].contact_birthday, a[i].contact_number = a[i+1].contact_number, a[i].contact_classification = a[i+1].contact_classification, a[i].contact_mail = a[i+1].contact_mail;
					a[i+1].contact_name = t_name, a[i].contact_birthday = t_birthday, a[i].contact_number = t_number, a[i].contact_classification = t_claddification, a[i].contact_mail = t_mail;
					
				}
			}
		}
	}
*/
}