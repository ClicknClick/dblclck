package dev.alexengrig.dblclck.exception;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(String hash) {
        super("URL not found by hash: '" + hash + "'.");
    }
}
