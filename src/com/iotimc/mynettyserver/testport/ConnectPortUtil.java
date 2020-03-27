package com.iotimc.mynettyserver.testport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectPortUtil {

	
	public static boolean isConnect(String host,int port){
	    Socket socket = new Socket();
	    try{
             socket.connect(new InetSocketAddress(host, port));
        }catch (IOException e) {
        	//System.out.println("fail");
        	e.printStackTrace();
        	return false;
        }finally{
           try{
               socket.close();
           }catch (IOException e) {
             e.printStackTrace();
           }
       }
	  return true;
	}
}
