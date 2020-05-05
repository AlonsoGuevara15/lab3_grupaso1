package com.example.laboratorio3.repository;

import com.example.laboratorio3.dto.DepartamentoPaisCiudad;
import com.example.laboratorio3.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespartmentsRepository extends JpaRepository<Departments,Integer> {

    @Query(value="SELECT count(d.department_name) as cantidad, l.city as ciudad, c.country_name as pais\n" +
            "FROM employees e\n" +
            "INNER JOIN departments d ON e.department_id=d.department_id\n" +
            "INNER JOIN (SELECT d.department_name \n" +
            "FROM employees e\n" +
            "INNER JOIN departments d ON e.department_id= d.department_id\n" +
            "group by d.department_id\n" +
            "HAVING count(e.employee_id)>3) subQuery ON subQuery.department_name=d.department_name\n" +
            "INNER JOIN locations l ON d.location_id=l.location_id\n" +
            "INNER JOIN countries c ON l.country_id=c.country_id\n" +
            "group by l.city",nativeQuery=true)
    List<DepartamentoPaisCiudad> obtenerDepartamentoPaisCiudad();

}
