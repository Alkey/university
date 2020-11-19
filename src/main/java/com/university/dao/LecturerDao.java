package com.university.dao;

import com.university.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerDao extends JpaRepository<Lecturer, Long> {
    List<Lecturer> findLecturersByNameContains(String template);

    Lecturer findByName(String name);
}
