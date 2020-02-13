package dev.alexengrig.dblclck.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping
    public String get() {
        return "Welcome to dblclck!";
    }
}
