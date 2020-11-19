package com.university.service.impl;

import com.university.dao.DepartmentDao;
import com.university.model.Department;
import com.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public Department findByName(String name) {
        return departmentDao.findByNameIgnoreCase(name);
    }


    @Override
    public Integer getAverageSalary(String departmentName) {
        return departmentDao.getAverageSalary(departmentName);
    }
}
