package com.university;

import com.university.console.MenuConsole;
import com.university.service.InjectDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationMain implements CommandLineRunner {

    private final MenuConsole menuConsole;
    private final InjectDataService injectDataService;

    @Override
    public void run(String... args) throws Exception {
        injectDataService.inject();
        menuConsole.start();
    }
}
