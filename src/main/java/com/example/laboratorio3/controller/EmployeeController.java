package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Departments;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.Job;
import com.example.laboratorio3.repository.DespartmentsRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

//COMPLETAR
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    //COMPLETAR
    @Autowired
    EmployeesRepository employeeRepository;
    @Autowired
    DespartmentsRepository despartmentsRepository;
    @Autowired
    JobRepository jobRepository;


    @GetMapping("/list")
    public String listaEmployee(Model model){
        //COMPLETAR
        List<Employees> listaEmp = employeeRepository.findAll();
        model.addAttribute("lista", listaEmp);
        return "employee/lista";
    }

    @GetMapping("/create")
    public String nuevoEmployeeForm(Model model) {
        //COMPLETAR
        List<Job> listaJob = jobRepository.findAll();
        List<Departments> listaDep = despartmentsRepository.findAll();
        List<Employees> listaMan = employeeRepository.findAll();
        model.addAttribute("listaJob", listaJob);
        model.addAttribute("listaDep", listaDep);
        model.addAttribute("listaMan", listaMan);
        return "employee/newFrm";
    }


    @PostMapping("/save")
    public String guardarEmployee(Employees employees,
                                  RedirectAttributes attr) {
        //COMPLETAR
        if(employees.getEmployeeid()!=null) {
            attr.addFlashAttribute("msg","Empleado actualizado exitosamente");
        } else {
            attr.addFlashAttribute("msg","Empleado creado exitosamente");
        }
        employeeRepository.save(employees);
        return "redirect:/employee/lista";
    }

    @GetMapping("/edit")
    public String editarEmployee(@RequestParam("id") int id,
                                 Model model) {
        //COMPLETAR
        Optional<Employees> opt = employeeRepository.findById(id);
        if (opt.isPresent()) {
            Employees employees =opt.get();

            List<Job> listaJob = jobRepository.findAll();
            List<Departments> listaDep = despartmentsRepository.findAll();
            List<Employees> listaMan = employeeRepository.findAll();
            model.addAttribute("listaJob", listaJob);
            model.addAttribute("listaDep", listaDep);
            model.addAttribute("listaMan", listaMan);
            model.addAttribute("employee", employees);

            return "employee/editFrm";

        } else {
            return "redirect:/employee/lista";
        }
    }


    public String borrarEmpleado(@RequestParam("id") int id,
                                 RedirectAttributes attr) {
       //COMPLETAR
        Optional<Employees> opt = employeeRepository.findById(id);
        if (opt.isPresent()) {
            employeeRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Empleado borrado exitosamente");
        }
        return "redirect:/employee/lista";
    }

    //COMPLETAR
    @PostMapping("/buscarEmpleado")
    public String buscarPorNombreRegion(@RequestParam("searchField") String sf,
                                        Model model) {
        List<Employees> listaEmp = employeeRepository.findByFirst_nameOrLast_name(sf);
        model.addAttribute("lista", listaEmp);
        return "region/listar";
    }

}
