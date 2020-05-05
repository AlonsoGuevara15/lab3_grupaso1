package com.example.laboratorio3.controller;


import com.example.laboratorio3.entity.Departments;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.History;
import com.example.laboratorio3.entity.Job;
import com.example.laboratorio3.repository.DespartmentsRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.HistoryRepository;
import com.example.laboratorio3.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("history")
public class HistoryController {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    DespartmentsRepository despartmentsRepository;


    @GetMapping("lista")
    public String Historial(Model model){

        List<Employees> listaEmployee = employeesRepository.findAll();
        List<History> listaHistory = historyRepository.findAll();
        List<Job> listaJob = jobRepository.findAll();
        List<Departments> listaDepartement = despartmentsRepository.findAll();
        model.addAttribute("listaEmployee",listaEmployee);
        model.addAttribute("listaHistory",listaHistory);
        model.addAttribute("listaJob",listaJob);
        model.addAttribute("listaDepartement",listaDepartement);

        return "history/lista";
    }

    @GetMapping("reporteDepartamentoPaisCiudad")
    public String reporteDepartamentoPaisCiudad(Model model){
        model.addAttribute("obtenerDepartamentoPaisCiudad",despartmentsRepository.obtenerDepartamentoPaisCiudad());
        return "Search/departamentoPaisCiudad";
    }

}
