package com.university.console;

public interface ConsoleCommandExecutor {
    void executeCommand(String name);

    boolean validateCommand(String command);
}
