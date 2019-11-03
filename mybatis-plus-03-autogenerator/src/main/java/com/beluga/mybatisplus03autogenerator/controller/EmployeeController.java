package com.beluga.mybatisplus03autogenerator.controller;


import com.beluga.mybatisplus03autogenerator.beans.Employee;
import com.beluga.mybatisplus03autogenerator.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 陈健Beluga
 * @since 2019-11-03
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @GetMapping("/login")
    public List<Employee> login(){
        return employeeService.list();
    }
}

