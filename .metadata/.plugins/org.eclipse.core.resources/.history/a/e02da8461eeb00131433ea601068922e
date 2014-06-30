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
				.withIdentity("job1", "group1")
				.usingJobData("name", "Neha Talreja Jethwani")
				.usingJobData("age", 26)
				.build();

		Trigger simpletrigger1 = TriggerBuilder
				.newTrigger()
				.withIdentity("simpletrigger1", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
				.build();
		
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.scheduleJob(job1, simpletrigger1);
		scheduler.start();
		
	}

}
