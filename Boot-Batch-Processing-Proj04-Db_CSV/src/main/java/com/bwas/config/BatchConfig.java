package com.bwas.config;

import java.io.IOException;
import java.io.Writer;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.bwas.listner.JobMonitoringListner;
import com.bwas.mapper.ExamResultRowmapper;
import com.bwas.model.ExamResult;
import com.bwas.processor.ExamResultProcessor;

@Configuration
public class BatchConfig {
	
	@Autowired
	private JobMonitoringListner listener;
	@Autowired
	private DataSource ds;
	@Autowired
	private ExamResultProcessor processor;
	@Autowired
	private ExamResultRowmapper rowmapper;
	
	
	@Bean
	public JdbcCursorItemReader<ExamResult>  createReader(){
		return new JdbcCursorItemReaderBuilder()
				.name("read1")
				.dataSource(ds)
				.sql("select id,dob,semster,percentage from exam_result")
				.rowMapper(rowmapper)
				.build();
	}
	@Bean
	public FlatFileItemWriter<ExamResult> createWriter(){
		
		return new FlatFileItemWriterBuilder()
				.name("file1")
				.resource(new FileSystemResource("examresult.csv"))
				.lineSeparator("\r\n")
				.delimited()
				.delimiter(",")
				.names(new String[] {"id","dob","semster","percentage"})
				.headerCallback(new FlatFileHeaderCallback() {
					@Override
					public void writeHeader(Writer writer) throws IOException {
						writer.write("id,dob,semster,percentage");
					}
				})
				.append(true)
				.build();
	}
	@Bean
	public Step createStep(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("step1", jobRepository)
				.<ExamResult,ExamResult>chunk(5,platformTransactionManager)
				.reader(createReader())
				.processor(processor)
				.writer(createWriter())
				.build();
	}
	
	@Bean
	public Job createJob(JobRepository jobRepository,Step step1) {
		
		return new JobBuilder("job1", jobRepository)
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(step1)
				.build();
	}

}
