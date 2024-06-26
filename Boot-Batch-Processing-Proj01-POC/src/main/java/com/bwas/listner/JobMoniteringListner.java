package com.bwas.listner;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
@Component
public class JobMoniteringListner implements JobExecutionListener {
	
	private long startTime,endTime;
	
	

	public JobMoniteringListner() {
		System.out.println("JobMoniteringListner.JobMoniteringListner()");
	}
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job About Beging at ::"+new Date());
		startTime=System.currentTimeMillis();
		System.out.println("Jon Status "+jobExecution.getStatus());
		
	}
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job Complated at ::"+new Date());
		endTime=System.currentTimeMillis();
		System.out.println("Jon Status "+jobExecution.getStatus());
		System.out.println("Job Exection Time ::"+(endTime-startTime));
		System.out.println("Job Exit Status :: "+jobExecution.getExitStatus());
	}
}
