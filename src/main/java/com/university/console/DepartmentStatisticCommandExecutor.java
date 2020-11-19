package com.university.console;

import com.university.model.Degree;
import com.university.model.Department;
import com.university.model.Lecturer;
import com.university.model.Role;
import com.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class DepartmentStatisticCommandExecutor implements ConsoleCommandExecutor {
    private static final String STATISTICS = "statistics";
    private final DepartmentService service;

    @Override
    public void executeCommand(String command) {
        String name = command.replace("Show", "").replace(STATISTICS, "").trim();
        Map<Role, Long> statistics = Stream.ofNullable(service.findByName(name))
                .map(Department::getLecturers)
                .flatMap(Collection::stream)
                .map(Lecturer::getDegree)
                .map(Degree::getRole)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (CollectionUtils.isEmpty(statistics)) {
            System.out.println("Incorrect department name " + name);
            return;
        }
        System.out.println("Assistants: " + statistics.getOrDefault(Role.ASSISTANT, 0L)
                + "\nAssociate professors: " + statistics.getOrDefault(Role.ASSOCIATE_PROFESSOR, 0L)
                + "\nProfessors: " + statistics.getOrDefault(Role.PROFESSOR, 0L));
    }

    @Override
    public boolean validateCommand(String command) {
        return command.contains(STATISTICS);
    }
}
