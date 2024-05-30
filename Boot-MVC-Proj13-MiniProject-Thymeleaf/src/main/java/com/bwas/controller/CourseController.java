package com.bwas.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bwas.model.Course;
import com.bwas.service.iCourseMgmtService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private iCourseMgmtService courseMgmtService;

	@GetMapping("/")
	public String welcomePage() {
		return "index";
	}

	@GetMapping("/cur_details")
	public String getCourses(Map<String, Object> map) {
		List<Course> list = courseMgmtService.getAllCourses();
		map.put("courseList", list);
		return "course_details";
	}

	@GetMapping("/cur_add")
	public String registerCourseForm(@ModelAttribute("cur") Course course, Map<String, Object> map) {

		return "course_registration";
	}

	@PostMapping("/cur_add")
	public String registerCourse(@ModelAttribute("cur") Course course, RedirectAttributes attr) {

		String msg = courseMgmtService.addCourse(course);
		attr.addFlashAttribute("resultMsg", msg);

		return "redirect:cur_details";

	}

	@GetMapping("/cur_edit")
	public String fetchCourseByid(@RequestParam("no") Integer no,@ModelAttribute("cur") Course course) {

		Course cur = courseMgmtService.getCourseByid(no);
		BeanUtils.copyProperties(cur, course);
		
		return "course_update";

	}
	@PostMapping("/cur_edit")
	public String updatedCourseDetais(@ModelAttribute("cur") Course course,RedirectAttributes attr){
		
	String msg=	courseMgmtService.updateCourse(course);
	attr.addFlashAttribute("resultMsg",msg);
	return "redirect:cur_details";
	}
	@GetMapping("/cur_delete")
	public String deleteByid(@RequestParam("no") Integer id,RedirectAttributes attr) {
		
		String msg = courseMgmtService.deleteByid(id);
		attr.addFlashAttribute("resultMsg",msg);
		return "redirect:cur_details";
	}
}
