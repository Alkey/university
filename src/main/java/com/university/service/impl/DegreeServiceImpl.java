package com.university.service.impl;

import com.university.dao.DegreeDao;
import com.university.model.Degree;
import com.university.model.Role;
import com.university.service.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DegreeServiceImpl implements DegreeService {
    private final DegreeDao dao;

    @Override
    public void save(Degree degree) {
        dao.save(degree);
    }

    @Override
    public Degree findByName(String name) {
        return dao.findByRole(Role.valueOf(name));
    }
}
