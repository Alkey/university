package com.university.service.impl;

import com.university.dao.LecturerDao;
import com.university.model.Lecturer;
import com.university.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LecturerServiceImpl implements LecturerService {
    private final LecturerDao dao;

    @Override
    public void save(Lecturer lecturer) {
        dao.save(lecturer);
    }

    @Override
    public List<Lecturer> findLecturersByNameLike(String template) {
        List<Lecturer> lecturers = dao.findLecturersByNameContains(template);
        if (lecturers.isEmpty()) {
            System.out.println("Can't find lecturers with this template: " + template);
        }
        return lecturers;
    }

    @Override
    public Lecturer findByName(String name) {
        return dao.findByName(name);
    }
}
