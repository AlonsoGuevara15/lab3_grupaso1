package com.example.laboratorio3.controller;

import com.example.laboratorio3.dto.gerenteExperiencia;
import com.example.laboratorio3.dto.mayorSalario;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//COMPLETAR

@RequestMapping("/search")
@Controller
public class SearchController {

    //COMPLETAR
    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"", "/"})
    public String indice() {
        return "Search/indice";
    }

    @GetMapping("/mayorsalario")
    public String mayorsalario(Model m) {
        List<mayorSalario> mayorSalarios = employeesRepository.obtenerEmpleadosSalario();
        m.addAttribute("lista",mayorSalarios);
        return "Search/empleadoMayorSalario";
    }

    @GetMapping("/salarioDepart")
    public String salarioporDepa() {
        return "Search/salarioDepartamento";
    }

    @GetMapping("/depaPaisCiudad")
    public String depaPaisCiudad() {
        return "Search/departamentoPaisCiudad";
    }

    @GetMapping("/gerenteExperiencia")
    public String gerenteExperiencia(Model m) {
        List<gerenteExperiencia> gerenteExperiencias = employeesRepository.obtenerGerenteExperiencia();
        m.addAttribute("lista",gerenteExperiencias);

        return "Search/gerentesExperiencia";
    }
//COMPLETAR


}
