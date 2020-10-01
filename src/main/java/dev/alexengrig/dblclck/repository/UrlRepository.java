package dev.alexengrig.dblclck.repository;

import dev.alexengrig.dblclck.entity.HashedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<HashedUrl, Long> {
    boolean existsByHash(String hash);

    Optional<HashedUrl> findByHash(String hash);
}
