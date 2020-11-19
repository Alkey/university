package com.university.console;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class MenuConsole {
    private static final String GREETINGS = "Hello, please choose command: "
            + "\n 1. Enter \"Who is head of department {department_name}\""
            + "\n 2. Enter \"Show {department_name} statistics\""
            + "\n 3. Enter \"Show the average salary for the department {department_name}\""
            + "\n 4. Enter \"Show count of employee for {department_name}\" "
            + "\n 5. Enter \"Global search by {template}\""
            + "\n 6. Enter \"quit\" for exit";
    private final CommandHandler commandHandler;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(GREETINGS);
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                System.exit(0);
            } else {
                commandHandler.execute(line);
            }
        }
    }
}
