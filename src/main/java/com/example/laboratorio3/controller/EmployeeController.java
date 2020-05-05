package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//COMPLETAR
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    //COMPLETAR
    @Autowired
    EmployeesRepository employeeRepository;

    @GetMapping("/list")
    public String listaEmployee(   ){
        //COMPLETAR
        List<Employees> listaEmp = employeeRepository.findAll();
        model.addAttribute("lista", listaEmp);
        return "employee/lista";
    }

    public String nuevoEmployeeForm( ) {
        //COMPLETAR
    }


    public String guardarEmployee() {
        //COMPLETAR
    }


    public String editarEmployee() {
        //COMPLETAR
    }


    public String borrarEmpleado() {

       //COMPLETAR

    }

    //COMPLETAR

}
