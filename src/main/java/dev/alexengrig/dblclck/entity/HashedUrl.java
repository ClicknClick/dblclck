package dev.alexengrig.dblclck.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HashedUrl {
    @Id
    @GeneratedValue
    private Long id;
    private String hash;
    private String url;
}
