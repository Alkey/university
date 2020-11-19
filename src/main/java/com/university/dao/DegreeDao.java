package com.university.dao;

import com.university.model.Degree;
import com.university.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeDao extends JpaRepository<Degree, Long> {
    Degree findByRole(Role role);
}
