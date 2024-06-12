package com.bwas.validation;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bwas.model.Course;

public class CourseValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
	
		return clazz.isAssignableFrom(Course.class);
	}
	@Override
	public void validate(Object target, Errors errors) {
		Course course = (Course)target;
		if(course.getName()==null || course.getName().isBlank()) {
			errors.rejectValue("name", "cur.name.required");
		}
		else if(course.getName().length()<4 || course.getName().length()>=15) {
			errors.rejectValue("name", "cur.name.length");
		}
		if(course.getFee()==null || course.getFee()>=0) {
			errors.rejectValue("fee", "cur.fee.required");
		}
		if(course.getStartsDate()==null || course.getStartsDate().isAfter(LocalDate.now())) {
			errors.rejectValue("startsDate", "cur.startdate.required");
		}
		if(course.getContent()==null || course.getContent().isBlank()) {
			errors.rejectValue("content", "cur.content.required");
		}else if(course.getContent().length()>=10 || course.getContent().length()<=250) {
			errors.rejectValue("content", "cur.content.length");
			
		}
	}
}
