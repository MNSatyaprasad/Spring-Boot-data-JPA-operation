package com.bwas.repositatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bwas.model.Course;

public interface ICourseRepo extends JpaRepository<Course, Integer>{

}
