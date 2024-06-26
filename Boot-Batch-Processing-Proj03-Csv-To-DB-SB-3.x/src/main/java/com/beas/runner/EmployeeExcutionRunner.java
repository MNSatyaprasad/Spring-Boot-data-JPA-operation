/*
 * package com.beas.runner;
 * 
 * import java.util.Random;
 * 
 * import org.springframework.batch.core.Job; import
 * org.springframework.batch.core.JobExecution; import
 * org.springframework.batch.core.JobParameters; import
 * org.springframework.batch.core.JobParametersBuilder; import
 * org.springframework.batch.core.launch.JobLauncher; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class EmployeeExcutionRunner implements CommandLineRunner {
 * 
 * @Autowired private JobLauncher jobLauncher;
 * 
 * @Autowired private Job job;
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * JobParameters parameter = new JobParametersBuilder() .addLong("run.id", new
 * Random().nextLong(1000)).toJobParameters(); JobExecution execution =
 * jobLauncher.run(job, parameter);
 * System.out.println("Job Excution Status::"+execution.getExitStatus());
 * 
 * }
 * 
 * }
 */