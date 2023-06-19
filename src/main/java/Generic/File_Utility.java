package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility
{
public static String get_property_data(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream(Iconstantpaths.filepath);
	Properties pObj=new Properties();
	pObj.load(fis);
	String value=pObj.getProperty(key);
	return value;
}
	
	
}
