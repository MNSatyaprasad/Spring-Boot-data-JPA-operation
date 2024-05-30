package com.bwas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.model.Course;
import com.bwas.repositatory.ICourseRepo;

@Service
public class CourseMgmtService implements iCourseMgmtService {
	
	@Autowired
	private ICourseRepo repo;
	
	
	@Override
	public List<Course> getAllCourses() {
		
		return repo.findAll();
	}

	@Override
	public String addCourse(Course course) {
	
		return "Course is saved sucessfully ::"+repo.save(course).getId();
	}
	@Override
	public Course getCourseByid(Integer no)  {
		
		Course cur=  repo.findById(no).orElseThrow(()-> new IllegalArgumentException("No Id is found"));
			return cur;
	}
	@Override
	public String updateCourse(Course course) {
		
		return repo.save(course).getName()+"  Update Sucessfully";
	}
	@Override
	public String deleteByid(Integer id) {
		repo.deleteById(id);
		return "Deleted SucessFully with id::"+id;
	}
}
