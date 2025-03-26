package com.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StartApp {

	public static void main(String[] args) {
		try {
			Logger logger=Logger.getInstance();
			Scanner sc1=new Scanner(System.in);
			Scanner sc2=new Scanner(System.in);
			Logger.getInstance().log("starting TaskManager..");
			int ch1=0,ch2=0,ch3=0;
			String catName,taskName,desc,tags,spldt;
			int priority;
			TaskModel model=new TaskModel();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			while(ch1!=5)
			{
			System.out.println("press 1 to create category");
			System.out.println("press 2 to Load category");
			System.out.println("press 3 to search category");
			System.out.println("press 4 to List category");
			System.out.println("press 5 to exit category");

		
			while(!sc1.hasNextInt())
			{
				System.out.println("enter integer input");
				sc1.next();
			}
			ch1=sc1.nextInt();
			switch(ch1)
			{
			case 1:
			     System.out.println("creating the category");
			     System.out.println("Enter category name");
			     catName=sc2.nextLine();
			     while(!TaskUtil.validateName(catName))
			     {
			    	 System.out.println("category name must be single word,start with letter,only alphanumeric..enter another category name");
			         catName=sc2.nextLine();
			     }
			     if(model.checkIfCategoryExists(catName))
			     {
			    	 System.out.println("enter unique category name");
			     }
			     else
			     {
			    	 while(ch2!=6)
			    	 {
			    		 System.out.println("press 1 to create task");
			    		 System.out.println("press 2 to update task");
			    		 System.out.println("press 3 to remove task");
			    		 System.out.println("press 4 to list task");
			    		 System.out.println("press 5 to search task");
			    		 System.out.println("press 6 to go back");
			    		 ch2=sc1.nextInt();
			    		 switch(ch2)
			    		 {
			    		 case 1:
			    			 Logger.getInstance().log("creating task");
			    			 System.out.println("enter task name");
			    			 taskName=sc2.nextLine();
			    			 while(!TaskUtil.validateName(taskName))
						     {
						    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
						         taskName=sc2.nextLine();
						     }
			    			 System.out.println("enter description");
			    			 desc=sc2.nextLine();
			    			 System.out.println("enter tags(comma separated)");
			    			 tags=sc2.nextLine();
			    			 System.out.println("enter planned end date(dd/mm/yyyy)");
			    			 spldt=sc2.nextLine();
			    			 System.out.println("enter priority(1-very low, 10-very high)");
			    			 priority=sc1.nextInt();
			    			 Date dt=sdf.parse(spldt);
			    			 TaskBean bean=new TaskBean(taskName,desc,tags,dt,priority);
			    			 String result=model.createTask(bean,catName);
			    			 if(result.equals("SUCCESS"))
			    				 System.out.println("task"+taskName+"added successfully");
			    			 else
			    				 System.out.println("task addition failed. msg is"+result);
			    			 break;
			    		 case 2:
			    			 Logger.getInstance().log("updating task");
			    			 System.out.println("enter the taskname that exists");
			    			 String taskName1=sc2.nextLine();
			    			 System.out.println("contents of "+taskName1+"are");
			    			 List<TaskBean>tasks1=model.search(taskName1,catName);
			    			 if(tasks1==null)
			    			 {
			    				 System.out.println("searched task doesn't exists");
			    			 }
			    			 else
				    			for(TaskBean task:tasks1)
				    			{
				    				System.out.println("Name:"+task.getTaskName()+" description:"+task.getDesc()+" Priority:"+task.getPriority()+" Tags:"+task.getTags());
				    			
				    			while(ch3!=6)
				    			 {
				    			 System.out.println("press 1 to edit taskname");
				    			 System.out.println("press 2 to edit description");
				    			 System.out.println("press 3 to edit tags");
				    			 System.out.println("press 4 to edit planned date");
				    			 System.out.println("press 5 to edit priority");
				    			 System.out.println("press 6 to go back");
				    			 ch3=sc1.nextInt();
				    			 switch(ch1)
				    			 {
				    			 case 1:
				    				 System.out.println("enter the new task name to edit");
				    				 String newtaskName=sc2.nextLine();
				    				 while(!TaskUtil.validateName(newtaskName))
								     {
								    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
								         taskName=sc2.nextLine();
								     }
				    				 List<TaskBean> task8=model.update(catName, taskName1, newtaskName);
					    			 model.delete(taskName1, catName);
				    				 for(TaskBean task1:task8)
				    				 {
				    				 TaskBean bean1=new TaskBean(task1.getTaskName(),task1.getDesc(),task1.getTags(),task1.getPlannedDate(),task1.getPriority());
				    				 model.createTask(bean1, catName);
				    				 }
				    				 break;
				    			 case 2:
				    				 System.out.println("enter the new description to edit");
				    				 String newdesc=sc2.nextLine();
				    				 List<TaskBean> task1=model.update(catName, task.getDesc(), newdesc);
					    			 model.delete(taskName1, catName);
				    				 for(TaskBean task2:task1)
				    				 {
				    				 TaskBean bean1=new TaskBean(task2.getTaskName(),task2.getDesc(),task2.getTags(),task2.getPlannedDate(),task2.getPriority());
				    				 model.createTask(bean1, catName);
				    				 }
				    				 break;
				    			 case 3:
				    				 System.out.println("enter the new tags to edit");
				    				 String newtags=sc2.nextLine();
				    				 List<TaskBean> task2=model.update(catName, task.getTags(), newtags);
					    			 model.delete(taskName1, catName);
				    				 for(TaskBean task3:task2)
				    				 {
				    				 TaskBean bean1=new TaskBean(task3.getTaskName(),task3.getDesc(),task3.getTags(),task3.getPlannedDate(),task3.getPriority());
				    				 model.createTask(bean1, catName);
				    				 }
				    				 break;
				    			 case 4:
				    				 System.out.println("enter the new planned date to edit");
				    				 String newpldt=sc2.nextLine();
					    			 String dt1 =""+task.getPlannedDate();
				    				 List<TaskBean> task3=model.update(catName, dt1, newpldt);
					    			 model.delete(taskName1, catName);
				    				 for(TaskBean task4:task3)
				    				 {
				    				 TaskBean bean1=new TaskBean(task4.getTaskName(),task4.getDesc(),task4.getTags(),task4.getPlannedDate(),task4.getPriority());
				    				 model.createTask(bean1, catName);
				    				 }
				    				 
				    				 break;
				    			 case 5:
				    				 System.out.println("enter the new priority to edit");
				    				 String newpriority=sc2.nextLine();				    				 
				    				 String oldone=""+task.getPriority();
				    				 List<TaskBean> task4=model.update(catName, oldone, newpriority);
					    			 model.delete(taskName1, catName);
				    				 for(TaskBean task5:task4)
				    				 {
				    				 TaskBean bean1=new TaskBean(task5.getTaskName(),task5.getDesc(),task5.getTags(),task5.getPlannedDate(),task5.getPriority());
				    				 model.createTask(bean1, catName);
				    				 }
				    				 break;
				    			 case 6:
				    				 System.out.println("going back");
				    				 break;
				    			 }
				    			 }
				    		}
			    			        break;
			    		 case 3:
			    			 Logger.getInstance().log("removing task");
			    			 System.out.println("enter the taskname to remove");
			    			 String taskName5=sc2.nextLine();
			    			 while(!TaskUtil.validateName(taskName5))
						     {
						    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
						         taskName=sc2.nextLine();
						     }
			    			 List<TaskBean> result6=model.remove(taskName5, catName);
			    			 model.delete(taskName5, catName);
			    			 for(TaskBean task4:result6)
		    				 {
		    				 TaskBean bean1=new TaskBean(task4.getTaskName(),task4.getDesc(),task4.getTags(),task4.getPlannedDate(),task4.getPriority());
		    				 model.createTask(bean1, catName);
		    				 }
			    			 System.out.println("removed successfully");
			    			 break;
			    			 
			    		 case 4:
			    			 List<TaskBean>tasks2=model.getTasks(catName);
			    			for(TaskBean task:tasks2)
			    			{
			    				System.out.println("Name:"+task.getTaskName()+" description:"+task.getDesc()+"Priority:"+task.getPriority()+" Tags:"+task.getTags());
			    			}
			    			 break;
			    		 case 5:
			    			 System.out.println("enter the string to search");
			    			 String str=sc2.nextLine();
			    			 List<TaskBean>tasks7=model.search(str,catName);
			    			 if(tasks7==null)
			    			 {
			    				 System.out.println("searched task doesn't exists");
			    			 }
			    			 else
				    			for(TaskBean task:tasks7)
				    			{
				    				System.out.println("Name:"+task.getTaskName()+" description:"+task.getDesc()+" Priority:"+task.getPriority()+" Tags:"+task.getTags());
				    			}
			    			 break;
			    		 case 6:
			    			 System.out.println("going back");
			    			 break;
			    	     }

			    	 }
			     }
			     break;
			case 2:
				System.out.println("enter the existing category name to load");
				String catName1=sc2.nextLine();
				List<String>str=model.loadCategory(catName1);
				for(String strng:str)
				{
					System.out.println(strng);
				}
				 while(ch2!=6)
		    	 {
		    		 System.out.println("press 1 to create task");
		    		 System.out.println("press 2 to update task");
		    		 System.out.println("press 3 to remove task");
		    		 System.out.println("press 4 to list task");
		    		 System.out.println("press 5 to search task");
		    		 System.out.println("press 6 to go back");
		    		 ch2=sc1.nextInt();
		    		 switch(ch2)
		    		 {
		    		 case 1:
		    			 Logger.getInstance().log("creating task");
		    			 System.out.println("enter task name");
		    			 taskName=sc2.nextLine();
		    			 while(!TaskUtil.validateName(taskName))
					     {
					    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
					         taskName=sc2.nextLine();
					     }
		    			 System.out.println("enter description");
		    			 desc=sc2.nextLine();
		    			 System.out.println("enter tags(comma separated)");
		    			 tags=sc2.nextLine();
		    			 System.out.println("enter planned end date(dd/mm/yyyy)");
		    			 spldt=sc2.nextLine();
		    			 System.out.println("enter priority(1-very low, 10-very high)");
		    			 priority=sc1.nextInt();
		    			 Date dt=sdf.parse(spldt);
		    			 TaskBean bean=new TaskBean(taskName,desc,tags,dt,priority);
		    			 String result=model.createTask(bean,catName1);
		    			 if(result.equals("SUCCESS"))
		    				 System.out.println("task"+taskName+"added successfully");
		    			 else
		    				 System.out.println("task addition failed. msg is"+result);
		    			 break;
		    		 case 2:
		    			 Logger.getInstance().log("updating task");
		    			 System.out.println("enter the taskname that exists");
		    			 String taskName1=sc2.nextLine();
		    			 while(!TaskUtil.validateName(taskName1))
					     {
					    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
					         taskName=sc2.nextLine();
					     }
		    			 System.out.println("contents of "+taskName1+"are");
		    			 List<TaskBean>tasks1=model.search(taskName1,catName1);
		    			 if(tasks1==null)
		    			 {
		    				 System.out.println("searched task doesn't exists");
		    			 }
		    			 else
			    			for(TaskBean task:tasks1)
			    			{
			    				System.out.println("Name:"+task.getTaskName()+"description:"+task.getDesc()+"Priority:"+task.getPriority()+"Tags:"+task.getTags());
			    			
			    			while(ch3!=6)
			    			 {
			    			 System.out.println("press 1 to edit taskname");
			    			 System.out.println("press 2 to edit description");
			    			 System.out.println("press 3 to edit tags");
			    			 System.out.println("press 4 to edit planned date");
			    			 System.out.println("press 5 to edit priority");
			    			 System.out.println("press 6 to go back");
			    			 ch3=sc1.nextInt();
			    			 switch(ch1)
			    			 {
			    			 case 1:
			    				 System.out.println("enter the new task name to edit");
			    				 String newtaskName=sc2.nextLine();
			    				 while(!TaskUtil.validateName(newtaskName))
							     {
							    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
							         taskName=sc2.nextLine();
							     }
			    				 List<TaskBean> task8=model.update(catName1, taskName1, newtaskName);
				    			 model.delete(taskName1, catName1);
			    				 for(TaskBean task1:task8)
			    				 {
			    				 TaskBean bean1=new TaskBean(task1.getTaskName(),task1.getDesc(),task1.getTags(),task1.getPlannedDate(),task1.getPriority());
			    				 model.createTask(bean1, catName1);
			    				 }
			    				 break;
			    			 case 2:
			    				 System.out.println("enter the new description to edit");
			    				 String newdesc=sc2.nextLine();
			    				 List<TaskBean> task1=model.update(catName1, task.getDesc(), newdesc);
				    			 model.delete(taskName1, catName1);
			    				 for(TaskBean task2:task1)
			    				 {
			    				 TaskBean bean1=new TaskBean(task2.getTaskName(),task2.getDesc(),task2.getTags(),task2.getPlannedDate(),task2.getPriority());
			    				 model.createTask(bean1, catName1);
			    				 }
			    				 break;
			    			 case 3:
			    				 System.out.println("enter the new tags to edit");
			    				 String newtags=sc2.nextLine();
			    				 List<TaskBean> task2=model.update(catName1, task.getTags(), newtags);
				    			 model.delete(taskName1, catName1);
			    				 for(TaskBean task3:task2)
			    				 {
			    				 TaskBean bean1=new TaskBean(task3.getTaskName(),task3.getDesc(),task3.getTags(),task3.getPlannedDate(),task3.getPriority());
			    				 model.createTask(bean1, catName1);
			    				 }
			    				 break;
			    			 case 4:
			    				 System.out.println("enter the new planned date to edit");
			    				 String newpldt=sc2.nextLine();
				    			 String dt1 =""+task.getPlannedDate();
			    				 List<TaskBean> task3=model.update(catName1, dt1, newpldt);
				    			 model.delete(taskName1, catName1);
			    				 for(TaskBean task4:task3)
			    				 {
			    				 TaskBean bean1=new TaskBean(task4.getTaskName(),task4.getDesc(),task4.getTags(),task4.getPlannedDate(),task4.getPriority());
			    				 model.createTask(bean1, catName1);
			    				 }
			    				 
			    				 break;
			    			 case 5:
			    				 System.out.println("enter the new priority to edit");
			    				 String newpriority=sc2.nextLine();
			    				 String oldone=""+task.getPriority();
			    				 List<TaskBean> task4=model.update(catName1, oldone, newpriority);
				    			 model.delete(taskName1, catName1);
			    				 for(TaskBean task5:task4)
			    				 {
			    				 TaskBean bean1=new TaskBean(task5.getTaskName(),task5.getDesc(),task5.getTags(),task5.getPlannedDate(),task5.getPriority());
			    				 model.createTask(bean1, catName1);
			    				 }
			    				 break;
			    			 case 6:
			    				 System.out.println("going back");
			    				 break;
			    			 }
			    			 }
			    		}
		    			        break;
		    		 case 3:
		    			 Logger.getInstance().log("removing task");
		    			 System.out.println("enter the taskname to remove");
		    			 String taskName5=sc2.nextLine();
		    			 while(!TaskUtil.validateName(taskName5))
					     {
					    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
					         taskName=sc2.nextLine();
					     }
		    			 List<TaskBean> result6=model.remove(taskName5, catName1);
		    			 model.delete(taskName5, catName1);
		    			 for(TaskBean task4:result6)
	    				 {
	    				 TaskBean bean1=new TaskBean(task4.getTaskName(),task4.getDesc(),task4.getTags(),task4.getPlannedDate(),task4.getPriority());
	    				 model.createTask(bean1, catName1);
	    				 }
		    			 System.out.println("removed successfully");
		    			 break;
		    			 
		    		 case 4:
		    			 List<TaskBean>tasks2=model.getTasks(catName1);
		    			for(TaskBean task:tasks2)
		    			{
		    				System.out.println("Name:"+task.getTaskName()+" description:"+task.getDesc()+" Priority:"+task.getPriority()+" Tags:"+task.getTags());
		    			}
		    			 break;
		    		 case 5:
		    			 System.out.println("enter the string to search");
		    			 String str1=sc2.nextLine();
		    			 List<TaskBean>tasks7=model.search(str1,catName1);
		    			 if(tasks7==null)
		    			 {
		    				 System.out.println("searched task doesn't exists");
		    			 }
		    			 else
			    			for(TaskBean task:tasks7)
			    			{
			    				System.out.println("Name:"+task.getTaskName()+" description:"+task.getDesc()+" Priority:"+task.getPriority()+" Tags:"+task.getTags());
			    			}
		    			 break;
		    		 case 6:
		    			 System.out.println("going back");
		    			 break;
		    	     }

		    	 }
		     
				
				break;
			case 3:
				System.out.println("enter the existing category name to Search");
				String catName3=sc2.nextLine();
				List<String>str3=model.searchCategory(catName3);
				for(String strng:str3)
				{
					System.out.println(strng);
				}
				 while(ch2!=6)
		    	 {
		    		 System.out.println("press 1 to create task");
		    		 System.out.println("press 2 to update task");
		    		 System.out.println("press 3 to remove task");
		    		 System.out.println("press 4 to list task");
		    		 System.out.println("press 5 to search task");
		    		 System.out.println("press 6 to go back");
		    		 ch2=sc1.nextInt();
		    		 switch(ch2)
		    		 {
		    		 case 1:
		    			 Logger.getInstance().log("creating task");
		    			 System.out.println("enter task name");
		    			 taskName=sc2.nextLine();
		    			 while(!TaskUtil.validateName(taskName))
					     {
					    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
					         taskName=sc2.nextLine();
					     }
		    			 System.out.println("enter description");
		    			 desc=sc2.nextLine();
		    			 System.out.println("enter tags(comma separated)");
		    			 tags=sc2.nextLine();
		    			 System.out.println("enter planned end date(dd/mm/yyyy)");
		    			 spldt=sc2.nextLine();
		    			 System.out.println("enter priority(1-very low, 10-very high)");
		    			 priority=sc1.nextInt();
		    			 Date dt=sdf.parse(spldt);
		    			 TaskBean bean=new TaskBean(taskName,desc,tags,dt,priority);
		    			 String result=model.createTask(bean,catName3);
		    			 if(result.equals("SUCCESS"))
		    				 System.out.println("task"+taskName+"added successfully");
		    			 else
		    				 System.out.println("task addition failed. msg is"+result);
		    			 break;
		    		 case 2:
		    			 Logger.getInstance().log("updating task");
		    			 System.out.println("enter the taskname that exists");
		    			 String taskName1=sc2.nextLine();
		    			 while(!TaskUtil.validateName(taskName1))
					     {
					    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
					         taskName=sc2.nextLine();
					     }
		    			 System.out.println("contents of "+taskName1+"are");
		    			 List<TaskBean>tasks1=model.search(taskName1,catName3);
		    			 if(tasks1==null)
		    			 {
		    				 System.out.println("searched task doesn't exists");
		    			 }
		    			 else
			    			for(TaskBean task:tasks1)
			    			{
			    				System.out.println("Name:"+task.getTaskName()+" description:"+task.getDesc()+" Priority:"+task.getPriority()+" Tags:"+task.getTags());
			    			
			    			while(ch3!=6)
			    			 {
			    			 System.out.println("press 1 to edit taskname");
			    			 System.out.println("press 2 to edit description");
			    			 System.out.println("press 3 to edit tags");
			    			 System.out.println("press 4 to edit planned date");
			    			 System.out.println("press 5 to edit priority");
			    			 System.out.println("press 6 to go back");
			    			 ch3=sc1.nextInt();
			    			 switch(ch1)
			    			 {
			    			 case 1:
			    				 System.out.println("enter the new task name to edit");
			    				 String newtaskName=sc2.nextLine();
			    				 while(!TaskUtil.validateName(newtaskName))
							     {
							    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
							         taskName=sc2.nextLine();
							     }
			    				 List<TaskBean> task8=model.update(catName3, taskName1, newtaskName);
				    			 model.delete(taskName1, catName3);
			    				 for(TaskBean task1:task8)
			    				 {
			    				 TaskBean bean1=new TaskBean(task1.getTaskName(),task1.getDesc(),task1.getTags(),task1.getPlannedDate(),task1.getPriority());
			    				 model.createTask(bean1, catName3);
			    				 }
			    				 break;
			    			 case 2:
			    				 System.out.println("enter the new description to edit");
			    				 String newdesc=sc2.nextLine();
			    				 List<TaskBean> task1=model.update(catName3, task.getDesc(), newdesc);
				    			 model.delete(taskName1, catName3);
			    				 for(TaskBean task2:task1)
			    				 {
			    				 TaskBean bean1=new TaskBean(task2.getTaskName(),task2.getDesc(),task2.getTags(),task2.getPlannedDate(),task2.getPriority());
			    				 model.createTask(bean1, catName3);
			    				 }
			    				 break;
			    			 case 3:
			    				 System.out.println("enter the new tags to edit");
			    				 String newtags=sc2.nextLine();
			    				 List<TaskBean> task2=model.update(catName3, task.getTags(), newtags);
				    			 model.delete(taskName1, catName3);
			    				 for(TaskBean task3:task2)
			    				 {
			    				 TaskBean bean1=new TaskBean(task3.getTaskName(),task3.getDesc(),task3.getTags(),task3.getPlannedDate(),task3.getPriority());
			    				 model.createTask(bean1, catName3);
			    				 }
			    				 break;
			    			 case 4:
			    				 System.out.println("enter the new planned date to edit");
			    				 String newpldt=sc2.nextLine();
				    			 String dt1 =""+task.getPlannedDate();
			    				 List<TaskBean> task3=model.update(catName3, dt1, newpldt);
				    			 model.delete(taskName1, catName3);
			    				 for(TaskBean task4:task3)
			    				 {
			    				 TaskBean bean1=new TaskBean(task4.getTaskName(),task4.getDesc(),task4.getTags(),task4.getPlannedDate(),task4.getPriority());
			    				 model.createTask(bean1, catName3);
			    				 }
			    				 
			    				 break;
			    			 case 5:
			    				 System.out.println("enter the new priority to edit");
			    				 String newpriority=sc2.nextLine();
			    				 String oldone=""+task.getPriority();
			    				 List<TaskBean> task4=model.update(catName3, oldone, newpriority);
				    			 model.delete(taskName1, catName3);
			    				 for(TaskBean task5:task4)
			    				 {
			    				 TaskBean bean1=new TaskBean(task5.getTaskName(),task5.getDesc(),task5.getTags(),task5.getPlannedDate(),task5.getPriority());
			    				 model.createTask(bean1, catName3);
			    				 }
			    				 break;
			    			 case 6:
			    				 System.out.println("going back");
			    				 break;
			    			 }
			    			 }
			    		}
		    			        break;
		    		 case 3:
		    			 Logger.getInstance().log("removing task");
		    			 System.out.println("enter the taskname to remove");
		    			 String taskName5=sc2.nextLine();
		    			 while(!TaskUtil.validateName(taskName5))
					     {
					    	 System.out.println("Task name must be single word,start with letter,only alphanumeric..enter another category name");
					         taskName=sc2.nextLine();
					     }
		    			 List<TaskBean> result6=model.remove(taskName5, catName3);
		    			 model.delete(taskName5, catName3);
		    			 for(TaskBean task4:result6)
	    				 {
	    				 TaskBean bean1=new TaskBean(task4.getTaskName(),task4.getDesc(),task4.getTags(),task4.getPlannedDate(),task4.getPriority());
	    				 model.createTask(bean1, catName3);
	    				 }
		    			 break;
		    			 
		    		 case 4:
		    			 List<TaskBean>tasks2=model.getTasks(catName3);
		    			for(TaskBean task:tasks2)
		    			{
		    				System.out.println("Name:"+task.getTaskName()+"description:"+task.getDesc()+"Priority:"+task.getPriority()+"Tags:"+task.getTags());
		    			}
		    			 break;
		    		 case 5:
		    			 System.out.println("enter the string to search");
		    			 String str1=sc2.nextLine();
		    			 List<TaskBean>tasks7=model.search(str1,catName3);
		    			 if(tasks7==null)
		    			 {
		    				 System.out.println("searched task doesn't exists");
		    			 }
		    			 else
			    			for(TaskBean task:tasks7)
			    			{
			    				System.out.println("Name:"+task.getTaskName()+" description:"+task.getDesc()+" Priority:"+task.getPriority()+" Tags:"+task.getTags());
			    			}
		    			 break;
		    		 case 6:
		    			 System.out.println("going back");
		    			 break;
		    	     }

		    	 }
				 break;
			case 4:
   			 Logger.getInstance().log("listing categories");
				List<String>fa=model.listCategory();
				for(String f:fa)
				{
					System.out.println(f);
				}
				break;
				
			case 5:
   			 Logger.getInstance().log("Exit..");
				break;
			
			}
			
			
			}
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
