package com.bwas.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bwas.model.Employee;
@Component
public class EmployeeValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Employee emp = (Employee) target;
		if(emp.getName()==null || emp.getName().isBlank()) {
			errors.rejectValue("name", "emp.name.required");
		}else if(emp.getName().length()<5 || emp.getName().length()>=15)
			errors.rejectValue("name", "emp.name.length");
		
		if(emp.getJob()==null || emp.getJob().isBlank())
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5 ||emp.getJob().length()>15)
			errors.rejectValue("job", "emp.job.length");
		if(emp.getSalary()==null) {
			errors.rejectValue("salary", "emp.salary.reqired");
		}else if(emp.getSalary()<=10000 || emp.getSalary()>=100000) {
			errors.rejectValue("salary", "empl.salary.range");
		}
		if(emp.getDept()==null|| emp.getDept().isBlank()) {
			errors.rejectValue("dept", "emp.deptno.required");
		}
	}
}
