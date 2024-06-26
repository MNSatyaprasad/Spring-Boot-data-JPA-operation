package com.beas.listner;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
@Component
public class JobMoniteringListner implements JobExecutionListener {
	
	private long start,end;
	public JobMoniteringListner() {
		System.out.println("JobMoniteringListner.JobMoniteringListner()");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		start=System.currentTimeMillis();
		System.out.println("Job Exvtion Started::"+new Date());
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
	end=System.currentTimeMillis();
	System.out.println("Job Complated at::"+new Date());
	System.out.println("Job Excution Time "+(end-start)+"ms");
	System.out.println("Job Complated Status::"+jobExecution.getStatus());
		
	}

}
