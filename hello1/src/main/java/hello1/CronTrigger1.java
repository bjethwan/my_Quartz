package hello1;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


/*
 * http://quartz-scheduler.org/
 * 
 * What is Quartz?
 * Job Scheduling Library: Enterprise-class features, such as support for JTA transactions and clustering.
 * Apache 2.0 license.
 */
public class CronTrigger1 {
	public static void main(String[] args) throws SchedulerException {

		JobDetail job1 = JobBuilder
				.newJob(HelloWorldJob.class)
				.withIdentity("job1", "group1")
				.build();

		Trigger crontrigger1 = TriggerBuilder
				.newTrigger()
				.withIdentity("crontrigger1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
				.build();

		//schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job1, crontrigger1);

	}

}