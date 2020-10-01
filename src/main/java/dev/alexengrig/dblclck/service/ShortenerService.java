package dev.alexengrig.dblclck.service;

public interface ShortenerService {
    String shorten(String url);

    String unshorten(String hash);
}
