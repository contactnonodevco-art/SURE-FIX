package com.surefix.repository;

import com.surefix.entity.ErrorCode;
import com.surefix.enums.ApplianceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité ErrorCode (Code d'erreur)
 */
@Repository
public interface ErrorCodeRepository extends JpaRepository<ErrorCode, Integer> {

    /** Recherche par code et marque */
    Optional<ErrorCode> findByCodeAndBrandId(String code, Integer brandId);

    /** Recherche par code, marque et type d'appareil */
    Optional<ErrorCode> findByCodeAndBrandIdAndApplianceType(String code, Integer brandId, ApplianceType applianceType);

    /** Recherche par marque */
    List<ErrorCode> findByBrandId(Integer brandId);

    /** Recherche par type d'appareil */
    List<ErrorCode> findByApplianceType(ApplianceType applianceType);

    /** Recherche par marque et type d'appareil */
    List<ErrorCode> findByBrandIdAndApplianceType(Integer brandId, ApplianceType applianceType);

    /** Recherche par code (peut retourner plusieurs si même code pour différentes marques) */
    List<ErrorCode> findByCode(String code);

    /** Vérifie si un code existe pour une marque */
    boolean existsByCodeAndBrandId(String code, Integer brandId);
}
