package com.uttara;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
	public static final boolean LOGTOMONITOR=true;
	private Logger()
	{
		
	}
	private static Logger obj=null;
	public static Logger getInstance()
	{
		if(obj==null)
			obj=new Logger();
		
		return obj;
	}
	public void log(String data)
	{
		new Thread(new Runnable()
	 {
			public void run()
		{
		BufferedWriter bw=null;
		try
		{
			bw=new BufferedWriter(new FileWriter("log.txt",true));
			Date dt=new Date();
			String msg=dt+":"+data;
			bw.write(msg);
			bw.newLine();
			
			if(Logger.LOGTOMONITOR==true)
				System.out.println("Logger:"+msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null)
				try {
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
     }
    }).start();
	}
}