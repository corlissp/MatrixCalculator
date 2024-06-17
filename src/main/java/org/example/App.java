package org.example;

import lombok.RequiredArgsConstructor;
import org.example.controller.Controller;
import org.example.service.Printer;
import org.example.service.Service;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(new Printer(),
                                                scanner,
                                                new Service(scanner));
        controller.mainPage();
    }
}
