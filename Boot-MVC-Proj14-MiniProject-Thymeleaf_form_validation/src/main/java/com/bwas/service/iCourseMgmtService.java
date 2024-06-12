package com.bwas.service;

import java.util.List;

import com.bwas.model.Course;

public interface iCourseMgmtService {
	
	public List<Course> getAllCourses();
	
	public String addCourse(Course course);
	
	public Course getCourseByid(Integer no);
	
	public String updateCourse(Course course);
	
	public String deleteByid(Integer id);

}
