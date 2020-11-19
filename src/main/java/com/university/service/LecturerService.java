package com.university.service;

import com.university.model.Lecturer;

import java.util.List;

public interface LecturerService {
    void save(Lecturer lecturer);

    List<Lecturer> findLecturersByNameLike(String template);

    Lecturer findByName(String name);
}
