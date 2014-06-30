package com.bjethwan;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/*
 * Quartz always creates a new Job object to call its execute method.
 * You got to use JobDataMap to store any state infromation or config settings.
 */
public class TestJob implements Job{
	private String name;
	private int age;
	private String location;
	
	public void execute(JobExecutionContext context) throws JobExecutionException 
	{

		JobKey jobKey = context.getJobDetail().getKey();
	
		System.out.println(this +" Job: "+jobKey+"Hello Quartz! from "+name+"/"+age +" at "+location);	
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
