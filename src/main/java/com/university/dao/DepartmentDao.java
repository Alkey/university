package com.university.dao;

import com.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
    Department findByNameIgnoreCase(String name);

    @Query(value = "select AVG(l.salary) from departments as d " +
            "join departments_lecturers dl on d.id = dl.department_id " +
            "join lecturers as l on dl.lecturers_id=l.id " +
            "where d.name = :name", nativeQuery = true)
    Integer getAverageSalary(@Param("name") String name);
}
