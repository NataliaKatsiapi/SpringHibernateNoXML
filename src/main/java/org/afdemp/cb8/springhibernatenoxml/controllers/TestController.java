/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.cb8.springhibernatenoxml.controllers;

import java.util.List;
import javax.validation.Valid;
import org.afdemp.cb8.springhibernatenoxml.models.Employee;
import org.afdemp.cb8.springhibernatenoxml.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author George.Pasparakis
 */
@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = {"/", "/test"}, method = RequestMethod.GET)
    public String test(ModelMap model) {
        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("test", "This is a test!");
        return "test";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertForm(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@Valid Employee employee, BindingResult result, ModelMap model) {
        service.saveEmployee(employee);
        model.addAttribute("action", "insert");
        return "success";
    }

    @RequestMapping(value = "/delete/{ssn}", method = RequestMethod.GET)
    public String deleteBySsn(ModelMap model, @PathVariable String ssn) {

        service.deleteEmployeeBySsn(ssn);
        model.addAttribute("action", "Delete");

        return "success";
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateBySsn(ModelMap model, @PathVariable String id) {
        model.addAttribute("employee", service.findById(Integer.parseInt(id)));
        return "update";
    }
            
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    

}
