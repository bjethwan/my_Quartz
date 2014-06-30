package com.bjethwan;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class SchedulerApp {
	public static void main(String[] args) throws SchedulerException {

		JobDetail job1 = JobBuilder
				.newJob(TestJob.class)
				.storeDurably()
				.withIdentity("job1", "group1")
				.usingJobData("name", "Bipin Jethwani")
				.usingJobData("age", 32)
				.build();

		Trigger simpletrigger1 = TriggerBuilder
				.newTrigger()
				.forJob(job1)
				.withIdentity("simpletrigger1", "group1")
				.usingJobData("location", "Hyderabad")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
				.build();
		
		Trigger simpletrigger2 = TriggerBuilder
				.newTrigger()
				.forJob(job1)
				.withIdentity("simpletrigger2", "group1")
				.usingJobData("location", "Kanpur")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
				.build();
		
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.addJob(job1, true);
		scheduler.scheduleJob(simpletrigger1);
		scheduler.scheduleJob(simpletrigger2);
		scheduler.start();
		
		
		//Add the given JobDetail to the Scheduler, and associate the given Trigger with it.
//		scheduler.scheduleJob(job1, simpletrigger1);
//		scheduler.scheduleJob(job1, simpletrigger2);
	}

}
