package com.surefix.repository;

import com.surefix.entity.Appliance;
import com.surefix.enums.ApplianceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité Appliance (Appareil)
 */
@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Integer> {

    /** Recherche par numéro de modèle */
    Optional<Appliance> findByModelNumber(String modelNumber);

    /** Recherche par numéro de modèle et marque */
    Optional<Appliance> findByModelNumberAndBrandId(String modelNumber, Integer brandId);

    /** Recherche par marque */
    List<Appliance> findByBrandId(Integer brandId);

    /** Recherche par type d'appareil */
    List<Appliance> findByType(ApplianceType type);

    /** Recherche par marque et type */
    List<Appliance> findByBrandIdAndType(Integer brandId, ApplianceType type);

    /** Vérifie si un modèle existe pour une marque */
    boolean existsByModelNumberAndBrandId(String modelNumber, Integer brandId);
}
