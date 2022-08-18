package com.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.enumeration.DepartmentEnum;
import com.mvc.model.Employee;
import com.mvc.service.EmployeeService;

@Controller
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		return viewAllEmployee(model);
	}
	
	@RequestMapping("/view-all-employee")
	public String viewAllEmployee(Model model) {
		model.addAttribute("allEmployees", employeeService.getAllEmployee());
		return "view-all-employee";
	}
	
	//add employee
	@RequestMapping(value = "/add-employee", method = RequestMethod.GET)
	public String addEmployeeView(Model model) {
		
		model.addAttribute("newEmployee",new Employee());
		model.addAttribute("departmentEnumValues", DepartmentEnum.values());
		model.addAttribute("managers", employeeService.getAllEmployee());
		return "add-employee";
	}
	
	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("newEmployee") @Validated Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("newEmployee",employee);
			model.addAttribute("departmentEnumValues", DepartmentEnum.values());
			model.addAttribute("managers", employeeService.getAllEmployee());
			return "add-employee";
		}else {
			employeeService.addEmployee(employee);
			return viewAllEmployee(model);
		}
	}
	
	
	//update employee
	@RequestMapping(value = "/edit-employee", method = RequestMethod.GET)
	public String editEmployeeView(@RequestParam Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		if(employee!=null) {
			model.addAttribute("editEmployee",employee);
			model.addAttribute("departmentEnumValues", DepartmentEnum.values());
			model.addAttribute("managers", employeeService.getAllEmployee());
			return "edit-employee";
		}else {
			return viewAllEmployee(model);
		}
	}
	
	@RequestMapping(value = "/edit-employee", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute("editEmployee") @Validated Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("editEmployee",employee);
			model.addAttribute("departmentEnumValues", DepartmentEnum.values());
			model.addAttribute("managers", employeeService.getAllEmployee());
			return "edit-employee";
		}else {
			employeeService.updateEmployee(employee);
			return viewAllEmployee(model);
		}
	}
	
	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	 }
}
