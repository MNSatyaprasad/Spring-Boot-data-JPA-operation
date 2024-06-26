package com.beas.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.beas.listner.JobMoniteringListner;
import com.beas.model.Employee;
import com.beas.processer.EmployeeExcutionProceesor;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobMoniteringListner listner;
	@Autowired
	private EmployeeExcutionProceesor proceesor;
	@Autowired
	private DataSource dataSource;

	@Bean // builder patteren 
	public FlatFileItemReader<Employee> createFFReader() {
		return new FlatFileItemReaderBuilder<Employee>()
				.name("Flate-File")
				.resource(new ClassPathResource("EmployeeInfo.csv"))
				.delimited()
				.names("eno", "ename", "eaddrs", "salary")
				.targetType(Employee.class).build();
	}

	
	@Bean //builser patteren 
	public JdbcBatchItemWriter<Employee> createJBWrite(){
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(dataSource)
				.sql("insert into emps values (:eno,:ename,:eaddrs,:salary,:grosalary,:netsalary)")
				.beanMapped()
				.build();
		
	}
	@Bean(name = "step1")
	public Step createStep1(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager) {

		return new StepBuilder("task1",jobRepository)
				.<Employee, Employee>chunk(5,platformTransactionManager)
				.reader(createFFReader())
				.processor(proceesor).
				writer(createJBWrite()).
				build();
	}

	@Bean(name = "job1")
	public Job createJob(JobRepository jobBuilderFactory,Step step) {

		return new JobBuilder("jobTask1",jobBuilderFactory)
				.listener(listner)
				.incrementer(new RunIdIncrementer())
				.start(step).build();
	}
}
