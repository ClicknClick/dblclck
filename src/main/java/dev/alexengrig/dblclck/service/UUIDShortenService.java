package dev.alexengrig.dblclck.service;

import dev.alexengrig.dblclck.entity.HashedUrl;
import dev.alexengrig.dblclck.exception.UrlNotFoundException;
import dev.alexengrig.dblclck.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UUIDShortenService implements ShortenerService {
    private final UrlRepository repository;

    @Override
    public String shorten(String url) {
        Assert.hasLength(url, "Url must not be empty.");
        String hash = createUniqueHash();
        repository.save(HashedUrl.builder().url(url).hash(hash).build());
        return hash;
    }

    private String createUniqueHash() {
        String hash;
        do {
            hash = UUID.randomUUID().toString().substring(0, 6);
        } while (repository.existsByHash(hash));
        return hash;
    }

    @Override
    public String unshorten(String hash) {
        Assert.hasLength(hash, "Hash must not be empty.");
        return repository.findByHash(hash).map(HashedUrl::getUrl).orElseThrow(() -> new UrlNotFoundException(hash));
    }
}
