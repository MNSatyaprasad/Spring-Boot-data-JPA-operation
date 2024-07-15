package com.bwasrunner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BatchRunner implements CommandLineRunner {
	@Autowired
	private Job job;
	@Autowired
	private JobLauncher jobLauncher;

	@Override
	public void run(String... args) throws Exception {
		JobParameters jobParameter = new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.toJobParameters();

		JobExecution execution = jobLauncher.run(job, jobParameter);
	

	}

}
