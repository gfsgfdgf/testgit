package com.iotimc.mynettyserver.serverupdate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ServerUpdateUtil {
	
	public static String startService(String path){
		String result = "success";
		String webroot = ServerUpdateUtil.class.getResource(path).toString().replaceAll("file:/", "");
		System.out.println(webroot);
		Process p;    
		try{
			 p = Runtime.getRuntime().exec(webroot);   
			//取得命令结果的输出流    
             InputStream fis=p.getInputStream();    
            //用一个读输出流类去读    
             InputStreamReader isr=new InputStreamReader(fis);    
            //用缓冲器读行    
             BufferedReader br=new BufferedReader(isr);    
             String line=null;    
            //直到读完为止    
            while((line=br.readLine())!=null)    
             {    
                 System.out.println(line);    
             }    
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		return result;
	}
	
	public static String stopService(String path){
		String result = "success";
		String webroot = ServerUpdateUtil.class.getResource(path).toString().replaceAll("file:/", "");
		System.out.println(webroot);
		Process p;    
		try{
			 p = Runtime.getRuntime().exec(webroot);   
			//取得命令结果的输出流    
             InputStream fis=p.getInputStream();    
            //用一个读输出流类去读    
             InputStreamReader isr=new InputStreamReader(fis);    
            //用缓冲器读行    
             BufferedReader br=new BufferedReader(isr);    
             String line=null;    
            //直到读完为止    
            while((line=br.readLine())!=null)    
             {    
                 System.out.println(line);    
             }    
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		return result;
	}
	
}
