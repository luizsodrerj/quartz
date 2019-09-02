package qrtzlab;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

public class MainTrigger {
/*
	1.	Segundos;
	2.	Minutos;
	3.	Horas;
	4.	Dia do mês;
	5.	Mês;
	6.	Dia da semana;
	7.	Ano (opcional).
	
	todos os dias, as 08:00am e 12:00pm: “0 0 8,12 * * *”. 
	todas as quartas-feiras as 12:00pm:  “0 0 12 ? * WED”. 
*/
	
	public static void main(String[] args) throws Exception  {
		final JobKey jobKey = new JobKey("LogJobName", "group1");
        final JobDetail job = JobBuilder.newJob(LogJob.class).withIdentity(jobKey).build();
        CronScheduleBuilder schBuilder = CronScheduleBuilder.cronSchedule("0/15 * * ? * *");
        
        final Trigger trigger = TriggerBuilder.newTrigger()
        									  .withIdentity("TriggerName", "group1")
        									  .withSchedule(schBuilder)
        									  .build();
 
        final Scheduler scheduler = new StdSchedulerFactory().getScheduler();
 
        // Listener attached to jobKey
        scheduler.getListenerManager().addJobListener(new QuartzJobListener(), KeyMatcher.keyEquals(jobKey));
        scheduler.start();
        scheduler.scheduleJob(job, trigger);		
	}
	
}













