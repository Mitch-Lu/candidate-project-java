package com.zoomcare.candidatechallenge.repository;

import com.zoomcare.candidatechallenge.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
    @Query("SELECT distinct e FROM Employee e " +
            "LEFT JOIN e.employees LEFT JOIN e.properties WHERE e.supervisor IS NULL ")
    List<Employee> findAllTopLevelEmployees();
}