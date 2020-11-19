package com.university.console;

import com.university.model.Lecturer;
import com.university.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SearchByTemplateCommandExecutor implements ConsoleCommandExecutor {
    private static final String SEARCH_BY_TEMPLATE = "Global search by";
    private final LecturerService service;

    @Override
    public void executeCommand(String command) {
        String name = command.replace(SEARCH_BY_TEMPLATE, "").trim();
        System.out.println(service.findLecturersByNameLike(name).stream()
                .map(Lecturer::getName)
                .collect(Collectors.joining(", ")));
    }

    @Override
    public boolean validateCommand(String command) {
        return command.contains(SEARCH_BY_TEMPLATE);
    }
}
