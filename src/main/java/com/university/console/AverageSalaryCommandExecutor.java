package com.university.console;

import com.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;


@RequiredArgsConstructor
@Component
public class AverageSalaryCommandExecutor implements ConsoleCommandExecutor {
    private static final String AVERAGE_SALARY = "Show the average salary for the department";
    private final DepartmentService service;

    @Override
    public void executeCommand(String command) {
        String name = StringUtils.capitalize(command.replace(AVERAGE_SALARY, "").trim().toLowerCase());
        Optional.ofNullable(service.getAverageSalary(name)).ifPresentOrElse(
                d -> System.out.println("The average salary of " + name + " is " + d),
                () -> System.out.println("Incorrect name of department " + name)
        );
    }

    @Override
    public boolean validateCommand(String command) {
        return command.contains(AVERAGE_SALARY);
    }
}
