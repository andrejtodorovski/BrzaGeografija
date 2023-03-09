package com.example.brzageografija.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class River {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String riverName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        River river = (River) o;
        return id != null && Objects.equals(id, river.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
