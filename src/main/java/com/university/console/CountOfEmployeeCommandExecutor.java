package com.university.console;

import com.university.model.Department;
import com.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CountOfEmployeeCommandExecutor implements ConsoleCommandExecutor {
    private static final String COUNT_OF_EMPLOYEE = "Show count of employee for";
    private final DepartmentService service;

    @Override
    public void executeCommand(String command) {
        String name = command.replace(COUNT_OF_EMPLOYEE, "").trim();
        Optional.ofNullable(service.findByName(name)).map(Department::getLecturers).ifPresentOrElse(
                l -> System.out.println(l.size()),
                () -> System.out.println("Incorrect department name: " + name)
        );
    }

    @Override
    public boolean validateCommand(String command) {
        return command.contains(COUNT_OF_EMPLOYEE);
    }
}
