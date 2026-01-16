package com.surefix.repository;

import com.surefix.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité Shop (Atelier)
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    /** Recherche par nom */
    Optional<Shop> findByName(String name);

    /** Recherche par email */
    Optional<Shop> findByEmail(String email);

    /** Recherche par SIRET */
    Optional<Shop> findBySiret(String siret);

    /** Recherche les ateliers actifs */
    List<Shop> findByActive(Boolean active);

    /** Recherche par ville */
    List<Shop> findByCity(String city);

    /** Vérifie si un nom existe */
    boolean existsByName(String name);

    /** Vérifie si un SIRET existe */
    boolean existsBySiret(String siret);
}
