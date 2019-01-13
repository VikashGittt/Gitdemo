package com.automationpracticee.framework.utilityy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class ResourceHelper_v1 {
	public static String getResourcePath(String resource){
		String path = getBaseResourcePath()+resource;
		System.out.println("2 "+path);
		return path;
	}
	
	public static String getBaseResourcePath(){
		//System.out.println(ResourceHelper.class.getClass().getResource("resources"));		
		//String path = ResourceHelper.class.getClass().getResource("/").getPath();
		String path = System.getProperty("user.dir")+"\\"; //fetches the directory or path of the workspace for the current project
		
		System.out.println("1 "+path);
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String path) throws FileNotFoundException{
		return new FileInputStream(ResourceHelper_v1.getResourcePath(path));
	}
	public static void main(String[] args) throws FileNotFoundException{
		//System.out.println(ResourceHelper.getResourcePath("configfile/"+"config.properties"));
		getBaseResourcePath();
		
	}

}
	
