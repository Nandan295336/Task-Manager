package com.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class TaskModel {
	public List<TaskBean> remove(String taskName,String catName)
	{
		String line;
		BufferedReader br=null;
		try {
			List<TaskBean>tasks=new ArrayList<TaskBean>();
			TaskBean task;
			br=new BufferedReader(new FileReader(catName+".todo"));
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			while((line=br.readLine())!=null)
			{
				String[]sa=line.split(":");
				if(!(sa[0].equals(taskName)))
				{
					task=new TaskBean(sa[0],sa[1],sa[4],sdf.parse(sa[3]),Integer.parseInt(sa[2]));
					tasks.add(task);
				}
				else
				{
					continue;
				}
			}
			return tasks;
			}
		   catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			return null;
		}
		catch(ParseException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				}
			catch(IOException e2)
			{
				e2.printStackTrace();
			}

		}
	}
	public List<TaskBean> search(String str,String catName)
	{
	String line;
	BufferedReader br=null;
	try {
		List<TaskBean>tasks=new ArrayList<TaskBean>();
		TaskBean task;
		br=new BufferedReader(new FileReader(catName+".todo"));
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		while((line=br.readLine())!=null)
		{
			String[]sa=line.split(":");
			if((sa[0].equals(str))||(sa[1].equals(str))||(sa[2].equals(str))||(sa[3].equals(str))||(sa[4].equals(str)))
			{
				task=new TaskBean(sa[0],sa[1],sa[4],sdf.parse(sa[3]),Integer.parseInt(sa[2]));
			    tasks.add(task);
			}
			else
			{
			 continue;
			}
		}
		return tasks;
		}
	   catch (IOException e) 
	{
		e.printStackTrace();
		return null;
	}
	catch(NumberFormatException e)
	{
		e.printStackTrace();
		return null;
	}
	catch(ParseException e)
	{
		e.printStackTrace();
		return null;
	}
	finally
	{
		if(br!=null)
			try {
				br.close();
			}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}

	}
	}


	public String delete(String taskName,String catName)
	{
		BufferedReader br=null;
		BufferedWriter bw=null;
		Collection<String> col=new HashSet<String>();
		String line;
		try {
			br=new BufferedReader(new FileReader(catName+".todo"));
			bw=new BufferedWriter(new FileWriter(catName+".todo"));
			while((line=br.readLine())!=null)
			{
				String[] sa=line.split(":");
				if(sa[0].equals(taskName) ||sa[1].equals(taskName))
				{
				 
				}
				else 
				{
				col.add(line);	
				}	
			}
			for(String s:col)
			{
				bw.write(s);
			}
			return "SUCCESS";
			
		} catch (Exception e) {
			e.printStackTrace();
			return"oops, something went wrong"+e.getMessage();
		}
		finally
		{
			if (br!=null)
			{
			try {
				br.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				return"oops, something went wrong"+e2.getMessage();
			}
			}
			if(bw!=null)
			{
				try {
					bw.close();
					
				} catch (Exception e3) {
					e3.printStackTrace();
					return"oops, something went wrong"+e3.getMessage();

			}	
		}
		}
		
	}
	public List<TaskBean> update(String catName,String str,String newone)
	{
		String line;
		BufferedReader br=null;
		try {
			List<TaskBean>tasks=new ArrayList<TaskBean>();
			TaskBean task;
			br=new BufferedReader(new FileReader(catName+".todo"));
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			while((line=br.readLine())!=null)
			{
				String[]sa=line.split(":");
				if(sa[0].equals(str))
				{
					task=new TaskBean(newone,sa[1],sa[4],sdf.parse(sa[3]),Integer.parseInt(sa[2]));
				tasks.add(task);
				}
				if(sa[1].equals(str))
				{
					task=new TaskBean(sa[0],newone,sa[4],sdf.parse(sa[3]),Integer.parseInt(sa[2]));
					tasks.add(task);
				}
				if(sa[4].equals(str))
				{
					task=new TaskBean(sa[0],sa[1],newone,sdf.parse(sa[3]),Integer.parseInt(sa[2]));
					tasks.add(task);
				}
				if(sa[3].equals(str))
				{
					task=new TaskBean(sa[0],sa[1],sa[4],sdf.parse(newone),Integer.parseInt(sa[2]));
					tasks.add(task);	
				}
				if(sa[2].equals(str))
				{
					task=new TaskBean(sa[0],sa[1],sa[4],sdf.parse(sa[3]),Integer.parseInt(newone));
					tasks.add(task);
				}
				else if(!((sa[0].equals(str))||(sa[1].equals(str))||(sa[2].equals(str))||(sa[3].equals(str))||(sa[4].equals(str))))
				{
					continue;				
				}
			}
			return tasks;
			}
		   catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			return null;
		}
		catch(ParseException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				}
			catch(IOException e2)
			{
				e2.printStackTrace();
			}

		}
			
	}
	
	
	
	
	public List<TaskBean> getTasks(String catName)
	{
	String line;
	BufferedReader br=null;
	try {
		List<TaskBean>tasks=new ArrayList<TaskBean>();
		TaskBean task;
		br=new BufferedReader(new FileReader(catName+".todo"));
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		while((line=br.readLine())!=null)
		{
			String[]sa=line.split(":");
			task=new TaskBean(sa[0],sa[1],sa[4],sdf.parse(sa[3]),Integer.parseInt(sa[2]));
			tasks.add(task);
		}
		return tasks;
		}
	   catch (IOException e) 
	{
		e.printStackTrace();
		return null;
	}
	catch(NumberFormatException e)
	{
		e.printStackTrace();
		return null;
	}
	catch(ParseException e)
	{
		e.printStackTrace();
		return null;
	}
	finally
	{
		if(br!=null)
			try {
				br.close();
			}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}

	}
	}
	public String createTask(TaskBean task, String catName)
	{
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(catName+".todo",true));
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String pldt=sdf.format(d);
			bw.write(task.getTaskName()+":"+task.getDesc()+":"+task.getPriority()+":"+pldt+":"+task.getTags()+":"+d.getTime());
			bw.newLine();
			return "SUCCESS";
			} 
		    catch (Exception e) {
			e.printStackTrace();
			return "oops, something went wrong msg="+e.getMessage();
		}
		finally {
			if(bw!=null)
				try {
					bw.close();
				} catch (Exception e2) {
                   e2.printStackTrace();
                   }
		}
		
	}
	
	public boolean checkIfCategoryExists(String catName)
	{
		return new File(catName+".todo").exists();
	}
	public List<String> loadCategory(String catName)
	{
		List<String>tasks=new ArrayList<String>();
		BufferedReader br=null;
		String line;
		try
		{
	   File f=new File(catName+".todo");
	   if(f.exists()&& f.isFile())
	   {
		   
		   br=new BufferedReader(new FileReader(catName+".todo"));
		   while((line=br.readLine())!=null)
		   {
			 tasks.add(line);
		   }
	   }
	   else
	   {
		   tasks.add("category does not exist");
	   }
	   return tasks;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(br!=null)
			{
				try {
					br.close();
					
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			
		     }
		
		}
	}
	public List<String> searchCategory(String catName)
	{
		List<String>tasks=new ArrayList<String>();
		BufferedReader br=null;
		String line;
		try
		{
	   File f=new File(catName+".todo");
	   if(f.exists()&& f.isFile())
	   {
		   
		   br=new BufferedReader(new FileReader(catName+".todo"));
		   while((line=br.readLine())!=null)
		   {
			 tasks.add(line);
		   }
	   }
	   else
	   {
		   tasks.add("category does not exist");
	   }
	   return tasks;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(br!=null)
			{
				try {
					br.close();
					
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			
		     }
		
		}
	}
	public List<String> listCategory()
	{
		List<String>tasks=new ArrayList<String>();
		try
		{
	   File f=new File("f:\\Desktop\\eclipse programs\\TaskManager");
	   if(f.exists()&& f.isDirectory())
	   {
		   File[] fa=f.listFiles();
		   for(File f1:fa)
		   {
			   if(f1.getName().endsWith(".todo"))
			   {
			   tasks.add(f1.getName());
			   }
			   else
			   {
				   continue;
			   }
		   }
	   }
	   
	   
	   return tasks;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		}
}

