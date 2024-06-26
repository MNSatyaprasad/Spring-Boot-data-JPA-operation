package com.bwas.listner;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
@Component
public class JobMonitoringListner implements JobExecutionListener {
	private long start,end;
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		 start = System.currentTimeMillis();
		 System.err.println("Job Started at ::"+ new Date());
		 System.out.println("Job Status "+jobExecution.getStatus());
	}
	 
	@Override
	public void beforeJob(JobExecution jobExecution) {
		end = System.currentTimeMillis();
		System.out.println("Job Execution Time ::"+(end-start)+" ms");
		System.out.println("Job Execution Status "+jobExecution.getStatus());
	}
}
