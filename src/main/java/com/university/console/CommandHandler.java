package com.university.console;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CommandHandler {
    private final List<ConsoleCommandExecutor> commands;

    public void execute(String command) {
        commands.stream()
                .filter(x -> x.validateCommand(command))
                .findFirst()
                .ifPresentOrElse(x -> x.executeCommand(command),
                        () -> System.out.println("Unknown command"));
    }
}
