package com.university.service;

import com.university.model.Degree;

public interface DegreeService {
    void save(Degree degree);

    Degree findByName(String name);
}
