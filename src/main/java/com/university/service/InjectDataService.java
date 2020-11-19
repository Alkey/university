package com.university.service;

import com.university.model.Degree;
import com.university.model.Department;
import com.university.model.Lecturer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InjectDataService {
    private final DegreeService degreeService;
    private final DepartmentService departmentService;
    private final LecturerService lecturerService;

    public void inject() {
        Degree assistant = Degree.of("ASSISTANT");
        degreeService.save(assistant);
        Degree associateProfessor = Degree.of("ASSOCIATE_PROFESSOR");
        degreeService.save(associateProfessor);
        Degree professor = Degree.of("PROFESSOR");
        degreeService.save(professor);

        Lecturer ivanov = new Lecturer();
        ivanov.setName("Ivan Ivanov");
        ivanov.setSalary(1000);
        ivanov.setDegree(degreeService.findByName("ASSISTANT"));
        lecturerService.save(ivanov);
        Lecturer petrov = new Lecturer();
        petrov.setName("Petro Petrov");
        petrov.setSalary(2000);
        petrov.setDegree(degreeService.findByName("ASSOCIATE_PROFESSOR"));
        lecturerService.save(petrov);
        Lecturer alexandrov = new Lecturer();
        alexandrov.setName("Alexandr Alexandrov");
        alexandrov.setSalary(3000);
        alexandrov.setDegree(degreeService.findByName("PROFESSOR"));
        lecturerService.save(alexandrov);
        Lecturer andreev = new Lecturer();
        andreev.setName("Andrey Andreev");
        andreev.setSalary(2000);
        andreev.setDegree(degreeService.findByName("PROFESSOR"));
        lecturerService.save(andreev);
        Lecturer grigoriev = new Lecturer();
        grigoriev.setName("Grigory Grigoriev");
        grigoriev.setSalary(4000);
        grigoriev.setDegree(degreeService.findByName("ASSISTANT"));
        lecturerService.save(grigoriev);

        Department law = new Department();
        law.setName("Law");
        law.setHead(lecturerService.findByName("Alexandr Alexandrov"));
        List<Lecturer> lawLecturers = new ArrayList<>();
        lawLecturers.add(lecturerService.findByName("Andrey Andreev"));
        lawLecturers.add(lecturerService.findByName("Grigory Grigoriev"));
        lawLecturers.add(lecturerService.findByName("Alexandr Alexandrov"));
        law.setLecturers(lawLecturers);
        departmentService.save(law);
        Department economic = new Department();
        economic.setName("Economic");
        economic.setHead(lecturerService.findByName("Petro Petrov"));
        List<Lecturer> economicLecturers = new ArrayList<>();
        economicLecturers.add(lecturerService.findByName("Petro Petrov"));
        economicLecturers.add(lecturerService.findByName("Ivan Ivanov"));
        economicLecturers.add(lecturerService.findByName("Grigory Grigoriev"));
        economic.setLecturers(economicLecturers);
        departmentService.save(economic);
    }
}
