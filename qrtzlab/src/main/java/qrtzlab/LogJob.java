package qrtzlab;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class LogJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String h = df.format(new Date());

		System.out.println("-------------JOB EXECUTANDO------------");
		System.out.println("HORA EXECUCAO - " + h);
	}

}
