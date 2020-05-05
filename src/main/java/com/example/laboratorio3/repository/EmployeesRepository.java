package com.example.laboratorio3.repository;


import com.example.laboratorio3.dto.gerenteExperiencia;
import com.example.laboratorio3.dto.mayorSalario;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Query(value = "SELECT e.first_name as 'nombre', e.last_name as 'apellido', jh.start_date as 'fechainicio',jh.end_date as 'fechafin', j.job_title as 'Puesto'\n" +
            "FROM job_history jh\n" +
            "inner join employees e on jh.employee_id=e.employee_id\n" +
            "left join jobs j on jh.job_id=j.job_id\n" +
            "where e.salary>15000",nativeQuery = true)
    List<mayorSalario> obtenerEmpleadosSalario();
    @Query(value = "SELECT d.department_name as 'departamento', m.first_name as 'nombre', m.last_name as 'apellido', m.salary as 'sueldo'\n" +
            "FROM employees m\n" +
            "\n" +
            "left join job_history jh on jh.employee_id=m.employee_id\n" +
            "left join departments d on m.department_id=d.department_id\n" +
            "inner join employees e on m.employee_id=e.manager_id\n" +
            "group by m.employee_id\n" +
            "having sum(DATEDIFF(jh.end_date,jh.start_date)/365)>5\n" +
            "\n",nativeQuery = true)
    List<gerenteExperiencia> obtenerGerenteExperiencia();
}
