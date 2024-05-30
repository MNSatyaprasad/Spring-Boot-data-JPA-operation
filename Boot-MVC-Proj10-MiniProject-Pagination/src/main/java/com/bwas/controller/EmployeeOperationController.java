package com.bwas.controller;

import java.util.Map;

import org.hibernate.query.SortDirection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bwas.model.Employee;
import com.bwas.service.IEmployeeServive;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeServive service;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	/*
	 * @GetMapping("/emp_report") public String showEmployeeReport(Map<String,
	 * Object> map) {
	 * 
	 * Iterable<Employee> itEmps = service.getAllEmployees(); map.put("empList",
	 * itEmps); return "show_employee_report"; }
	 */

	/*
	 * @GetMapping("/emp_add") public String
	 * employeeRegisterForm(@ModelAttribute("emp") Employee emp) {
	 * 
	 * return "register_employee";
	 * 
	 * }
	 */

	/*
	 * @PostMapping("/emp_add") public String
	 * EmployeeRegister(@ModelAttribute("emp") Employee emp, Map<String, Object>
	 * map) {
	 * 
	 * String msg = service.registerEmployee(emp); Iterable<Employee> itemps =
	 * service.getAllEmployees(); map.put("resultMsg", msg); map.put("empList",
	 * itemps); return "show_employee_report";
	 * 
	 * }
	 */
	// Solving the double postion problem usin PRG problem

	/*
	 * @GetMapping("/emp_add") public String
	 * employeeRegisterForm(@ModelAttribute("emp") Employee emp) {
	 * 
	 * return "register_employee";
	 * 
	 * }
	 * 
	 * @PostMapping("/emp_add") public String
	 * EmployeeRegister(@ModelAttribute("emp") Employee emp, Map<String, Object>
	 * map) {
	 * 
	 * String msg = service.registerEmployee(emp); Iterable<Employee> itemps =
	 * service.getAllEmployees(); //map.put("resultMsg", msg); map.put("empList",
	 * itemps); return "redirect:emp_report";
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/emp_add") public String
	 * employeeRegisterForm(@ModelAttribute("emp") Employee emp) {
	 * 
	 * return "register_employee";
	 * 
	 * }
	 * 
	 * @PostMapping("/emp_add") public String
	 * EmployeeRegister(@ModelAttribute("emp") Employee emp, HttpSession session) {
	 * String msg = service.registerEmployee(emp); session.setAttribute("resultMsg",
	 * msg); return "redirect:emp_report";
	 * 
	 * }
	 */
	// To overcome the issue of the Showing result msg by replace the Map to change
	// RedirectAttributes for adding flush attributes

	@GetMapping("/emp_add")
	public String employeeRegisterForm(@ModelAttribute("emp") Employee emp) {

		return "register_employee";

	}

	@PostMapping("/emp_add")
	public String EmployeeRegister(@ModelAttribute("emp") Employee emp, RedirectAttributes attr) {
		String msg = service.registerEmployee(emp);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:emp_report";

	}

	// Updated the data
	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@ModelAttribute("emp") Employee emp, @RequestParam("no") Integer no) {

		Employee emp1 =  service.getEmployeeByNo(no);
		BeanUtils.copyProperties(emp1, emp);
		return "update_employee";
	}
	@PostMapping("/emp_edit")
	 public String showEmplueeUpdatedData(Employee emp,RedirectAttributes attr) {
		 
		 String msg = service.editEmployeeDetails(emp);
		 attr.addFlashAttribute("resultMsg",msg);
		 return "redirect:emp_report";
		 
	 }
	//Delete Operation
	@GetMapping("/emp_delete")
	public String deleteByEmployeeId(@RequestParam("no")  Integer eid, RedirectAttributes attr) {
		 String msg = service.deleteEmployeeById(eid);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:emp_report";
	}
	@GetMapping("/emp_report")
	public String ShowAllInPagenation(@PageableDefault(page = 0,size = 3,sort = "job",direction = Sort.Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		System.out.println("EmployeeOperationController.ShowAllInPagenation()");
		
		Page<Employee>  page = service.getAllByPagination(pageable);
		map.put("empData", page);
		
		return "show_employee_report";
	}
}
