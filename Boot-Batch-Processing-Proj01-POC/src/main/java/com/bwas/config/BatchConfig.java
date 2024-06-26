package com.bwas.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bwas.listner.JobMoniteringListner;
import com.bwas.processor.BookDetailsProcesser;
import com.bwas.reader.BookDetailsReader;
import com.bwas.writer.BookDetailsWriter;

//@SuppressWarnings("removal")
@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory builderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private BookDetailsWriter writer;
	@Autowired
	private BookDetailsReader reader;
	@Autowired
	private BookDetailsProcesser processer;
	@Autowired
	private JobMoniteringListner jobMoniteringListner;

    @Bean
    Step createStep1() {
		System.out.println("BatchConfig.createStep1()");
		return stepBuilderFactory.get("task1")
				.<String,String>chunk(3)
				.reader(reader)
				.writer(writer)
				.processor(processer)
				.build();
	}

    @Bean
    Job createJob() {
		System.out.println("BatchConfig.createJob()");
		return builderFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(jobMoniteringListner)
				.start(createStep1())
				.build();
	}
}
