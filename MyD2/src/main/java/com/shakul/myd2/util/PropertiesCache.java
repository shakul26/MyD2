package com.shakul.myd2.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {

	private  final Properties prop = new Properties();
	
	private PropertiesCache(){
		// private constructor to restrict ne instances
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("myd2.properties");
		
		try {
			prop.load(in);
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}

	private static class LazyHolder{
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	public static PropertiesCache getInstance(){
		return LazyHolder.INSTANCE;
	}
	
	public String getProperty(String key)
	{
		return prop.getProperty(key);
	}
	
	public Set<String> getAllPropertyNames(){
	      return prop.stringPropertyNames();
	   }
	    
	   public boolean containsKey(String key){
	      return prop.containsKey(key);
	   }
}
