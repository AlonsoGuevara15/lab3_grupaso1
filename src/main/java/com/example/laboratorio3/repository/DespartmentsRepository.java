package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespartmentsRepository extends JpaRepository<Departments,Integer> {
}
