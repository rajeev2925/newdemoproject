package Generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Java_Utility
{
public int Random_num()
{
	Random ran=new Random();
	int num=ran.nextInt(100,999);
	return num;
}

public String systemdate()
{
	SimpleDateFormat df=new SimpleDateFormat("ddMMyyyy");
	Date date=new Date();
	String cdate = df.format(date);
	String sdate = cdate.replace(":","-");
	return sdate;
}

public static String getdate()
{
	Date d=new Date();
	String cdate = d.toString();
	String sdate = cdate.replace(":","-");
	return sdate;
}

}
