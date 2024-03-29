package com.bjethwan;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory;


public class SchedulerApp {
	public static void main(String[] args) throws SchedulerException {
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		System.out.println("Starting scheduler");
		scheduler.start();	
		try {
            Thread.sleep(5L * 1000L); 
        } catch (Exception e) {
        }
        
        System.out.println("Shutting Down..");
        // shut down the scheduler
        scheduler.shutdown(true);

        SchedulerMetaData metaData = scheduler.getMetaData();
        System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
	}

}
