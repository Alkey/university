package com.university.console;

import com.university.model.Department;
import com.university.model.Lecturer;
import com.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@RequiredArgsConstructor
@Component
public class HeadOfDepartmentCommandExecutor implements ConsoleCommandExecutor {
    private static final String HEAD_OF_DEPARTMENT = "Who is head of department";
    private final DepartmentService service;

    @Override
    public void executeCommand(String command) {
        String name = command.replace(HEAD_OF_DEPARTMENT, "").trim();
        Optional.ofNullable(service.findByName(name))
                .map(Department::getHead)
                .map(Lecturer::getName)
                .ifPresentOrElse(
                        n -> System.out.println("Head of " + name + " department is " + n),
                        () -> System.out.println("Incorrect department name " + name)
                );
    }

    @Override
    public boolean validateCommand(String command) {
        return command.contains(HEAD_OF_DEPARTMENT);
    }
}
