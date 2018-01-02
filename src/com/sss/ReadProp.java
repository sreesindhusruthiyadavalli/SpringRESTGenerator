package com.sss;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ReadProp {
	
	public String getProps(String key){
	
	Properties prop = new Properties();
	InputStream input = null;
	//Logger log = new Logger(ReadProp.class);
	
	try{
		input = new FileInputStream("config.properties");
		prop.load(input);
		return prop.getProperty(key);
				
	}
	catch(IOException e){
		e.printStackTrace();
		
	}
	finally{
		if(input != null){
			try{
				input.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		}
	return null;
	}	

}
