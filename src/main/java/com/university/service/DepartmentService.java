package com.university.service;

import com.university.model.Department;


public interface DepartmentService {
    void save(Department department);

    Department findByName(String name);

    Integer getAverageSalary(String departmentName);
}
