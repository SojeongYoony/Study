package com.koreait.integration.batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

@WebListener
public class BookListener implements ServletContextListener {

    //field
	private SchedulerFactory factory;
	private Scheduler scheduler;
    public BookListener() {
        try {
        	factory = new StdSchedulerFactory();
        	scheduler = factory.getScheduler();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    // 종료 시점에서 해야 할 일
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    		if (scheduler != null) 
    			scheduler.shutdown();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}

	// 시작  		-- 1분마다 BookJob을 실행시킨다.
    public void contextInitialized(ServletContextEvent sce)  { 
         try {
        	 JobDetail job = JobBuilder.newJob(BookJob.class)
        			 .withIdentity("job1", "group1")
        			 .build();
        	 Trigger trigger = TriggerBuilder.newTrigger()
        			 .withIdentity("trigger1", "group1")
        			 .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))  // 표현식 : http://www.cronmaker.com/
        			 .build();
        	 scheduler.scheduleJob(job, trigger);
        	 scheduler.start();
         } catch (Exception e) {
        	 e.printStackTrace();
         }
    }
	
}
