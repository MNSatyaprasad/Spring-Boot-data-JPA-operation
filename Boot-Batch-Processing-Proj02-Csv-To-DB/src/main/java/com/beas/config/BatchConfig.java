package com.beas.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.codec.ByteArrayEncoder;
import org.springframework.core.io.ClassPathResource;

import com.beas.listner.JobMoniteringListner;
import com.beas.model.Employee;
import com.beas.processer.EmployeeExcutionProceesor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private JobMoniteringListner listner;
	@Autowired
	private EmployeeExcutionProceesor proceesor;
	@Autowired
	private DataSource dataSource;

	/*
	 * @Bean(name = "ffireader") public FlatFileItemReader<Employee>
	 * createFFReader() { // Create Reder Object FlatFileItemReader<Employee> reader
	 * = new FlatFileItemReader<Employee>(); // Set the File Location
	 * reader.setResource(new ClassPathResource("EmployeeInfo.csv")); // Create the
	 * LineMapper Object (To get the Each Line from CSV) DefaultLineMapper<Employee>
	 * lineMapper = new DefaultLineMapper<Employee>(); // Create LineTokenzier (To
	 * get the token from lines) DelimitedLineTokenizer lineTokenizer = new
	 * DelimitedLineTokenizer(); lineTokenizer.setDelimiter(",");
	 * lineTokenizer.setNames("eno", "ename", "eaddrs", "salary"); // Create
	 * FielsSetMapper (To Set the Token to Model Class objecrt Properties)
	 * BeanWrapperFieldSetMapper<Employee> setMapper = new
	 * BeanWrapperFieldSetMapper<Employee>();
	 * setMapper.setTargetType(Employee.class); // Set the Token Fiels SetMapper
	 * objects to Line Mapper lineMapper.setFieldSetMapper(setMapper);
	 * lineMapper.setLineTokenizer(lineTokenizer);
	 * 
	 * // Set the Line mapper to Reader Object reader.setLineMapper(lineMapper);
	 * 
	 * return reader;
	 * 
	 * }
	 */
	/*
	 * @Bean public FlatFileItemReader<Employee> createFFReader(){
	 * FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>() {{
	 * setResource(new ClassPathResource("EmployeeInfo.csv"));
	 * 
	 * 
	 * DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>() {{
	 * DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer() {{
	 * setDelimiter(","); setNames("eno", "ename", "eaddrs", "salary"); }};
	 * BeanWrapperFieldSetMapper<Employee> setMapper = new
	 * BeanWrapperFieldSetMapper<Employee>() {{ setTargetType(Employee.class);
	 * 
	 * }}; setFieldSetMapper(setMapper); setLineTokenizer(lineTokenizer); }};
	 * setLineMapper(lineMapper); }}; return reader; }
	 */
	/**
	 * @Bean // Instance Block Approach public FlatFileItemReader<Employee>
	 *       createFFReader() { FlatFileItemReader<Employee> reader = new
	 *       FlatFileItemReader<Employee>() { { setResource(new
	 *       ClassPathResource("EmployeeInfo.csv")); setLineMapper(new
	 *       DefaultLineMapper<Employee>() { { setLineTokenizer(new
	 *       DelimitedLineTokenizer() { { setDelimiter(","); } });
	 *       setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() { {
	 *       setTargetType(Employee.class); } });
	 * 
	 *       } });
	 * 
	 *       } }; return reader; }
	 **/
	@Bean // builder patteren 
	public FlatFileItemReader<Employee> createFFReader() {
		return new FlatFileItemReaderBuilder<Employee>()
				.name("Flate-File")
				.resource(new ClassPathResource("EmployeeInfo.csv"))
				.delimited()
				.names("eno", "ename", "eaddrs", "salary")
				.targetType(Employee.class).build();
	}

	/*
	 * @Bean(name = "jbiw") // Traditional Approach public
	 * JdbcBatchItemWriter<Employee> createJBWrite(){ //Create JDBC Item Writer
	 * Object JdbcBatchItemWriter<Employee> Writer = new
	 * JdbcBatchItemWriter<Employee>(); //ItemSqlParameterSourceProvider<Employee>
	 * provider = new BeanPropertyItemSqlParameterSourceProvider<Employee>();
	 * Writer.setDataSource(dataSource);
	 * 
	 * Writer.
	 * setSql("insert into emps values (:eno,:ename,:eaddrs,:salary,:grosalary,:netsalary)"
	 * ); BeanPropertyItemSqlParameterSourceProvider<Employee> provider = new
	 * BeanPropertyItemSqlParameterSourceProvider<Employee>();
	 * Writer.setItemSqlParameterSourceProvider(provider); return Writer;
	 * 
	 * }
	 **/
/**	@Bean(name = "jbiw") // Anynamous or Instance Block Approach
	public JdbcBatchItemWriter<Employee> createJBWrite() {
		// Create JDBC Item Writer Object
		return new JdbcBatchItemWriter<Employee>() {
			{
				setDataSource(dataSource);
				setSql("insert into emps values (:eno,:ename,:eaddrs,:salary,:grosalary,:netsalary)");
				setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
			}
		};

	}**/
	@Bean //builser patteren 
	public JdbcBatchItemWriter<Employee> createJBWrite(){
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(dataSource)
				.sql("insert into emps values (:eno,:ename,:eaddrs,:salary,:grosalary,:netsalary)")
				.beanMapped()
				.build();
		
	}
	@Bean(name = "step1")
	public Step createStep1() {

		return stepBuilderFactory.get("task1").<Employee, Employee>chunk(5).reader(createFFReader())
				.processor(proceesor).writer(createJBWrite()).build();
	}

	@Bean(name = "job1")
	public Job createJob() {

		return jobBuilderFactory.get("job1").listener(listner).incrementer(new RunIdIncrementer()).start(createStep1())
				.build();
	}
}
