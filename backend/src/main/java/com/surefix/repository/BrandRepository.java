package com.surefix.repository;

import com.surefix.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité Brand (Marque)
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    /** Recherche par nom */
    Optional<Brand> findByName(String name);

    /** Recherche par nom (insensible à la casse) */
    Optional<Brand> findByNameIgnoreCase(String name);

    /** Recherche les marques actives */
    List<Brand> findByActive(Boolean active);

    /** Vérifie si un nom existe */
    boolean existsByName(String name);

    /** Vérifie si un nom existe (insensible à la casse) */
    boolean existsByNameIgnoreCase(String name);
}
