package com.surefix.repository;

import com.surefix.entity.Diagnostic;
import com.surefix.enums.DiagnosticStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository pour l'entité Diagnostic
 */
@Repository
public interface DiagnosticRepository extends JpaRepository<Diagnostic, Integer> {

    /** Recherche par utilisateur */
    List<Diagnostic> findByUserId(Integer userId);

    /** Recherche par atelier */
    List<Diagnostic> findByShopId(Integer shopId);

    /** Recherche par statut */
    List<Diagnostic> findByStatus(DiagnosticStatus status);

    /** Recherche par utilisateur et statut */
    List<Diagnostic> findByUserIdAndStatus(Integer userId, DiagnosticStatus status);

    /** Recherche par atelier et statut */
    List<Diagnostic> findByShopIdAndStatus(Integer shopId, DiagnosticStatus status);

    /** Recherche par période */
    List<Diagnostic> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    /** Recherche par atelier et période */
    List<Diagnostic> findByShopIdAndCreatedAtBetween(Integer shopId, LocalDateTime start, LocalDateTime end);

    /** Compte les diagnostics par atelier */
    long countByShopId(Integer shopId);

    /** Compte les diagnostics par utilisateur */
    long countByUserId(Integer userId);
}
