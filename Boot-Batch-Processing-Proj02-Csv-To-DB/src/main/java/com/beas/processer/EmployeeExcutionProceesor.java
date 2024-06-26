package com.beas.processer;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.beas.model.Employee;
@Component
public class EmployeeExcutionProceesor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		
		if(item.getSalary()>=50000) {
			item.setGrosalary(item.getSalary()+(item.getSalary()*0.4));
			item.setNetsalary(item.getGrosalary()-(item.getGrosalary()*0.2));
			return item;
		}else
		return null;
	}

}
