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
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobKey jobKey = context.getJobDetail().getKey();
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		
		String name = jobDataMap.getString("name");
		Integer age = jobDataMap.getInt("age");
		
		System.out.println(this+" Job: "+jobKey+"Hello Quartz! from "+name+"/"+age);	
	}
}
