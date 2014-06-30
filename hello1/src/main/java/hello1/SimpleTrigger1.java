package hello1;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class SimpleTrigger1 {
	public static void main(String[] args) throws SchedulerException {

		JobDetail job1 = JobBuilder
				.newJob(HelloWorldJob.class)
				.withIdentity("job1", "group1")
				.build();

		Trigger simpletrigger1 = TriggerBuilder
				.newTrigger()
				.withIdentity("simpletrigger1", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
				.build();
		
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job1, simpletrigger1);
	}

}
