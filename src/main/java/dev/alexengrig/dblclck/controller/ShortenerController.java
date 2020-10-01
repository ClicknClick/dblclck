package dev.alexengrig.dblclck.controller;

import dev.alexengrig.dblclck.service.ShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shrt")
public class ShortenerController {
    private final ShortenerService service;

    @PostMapping
    public ResponseEntity<String> create(@PathParam("url") String url) {
        return ResponseEntity.ok(service.shorten(url));
    }

    @GetMapping("/{hash}")
    public ResponseEntity<String> get(@PathVariable String hash) {
        return ResponseEntity.ok(service.unshorten(hash));
    }
}
