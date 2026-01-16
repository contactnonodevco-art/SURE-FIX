package com.surefix.entity;

import com.surefix.enums.ApplianceType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Code d'erreur d'un appareil électroménager
 * Contient les informations de diagnostic associées au code
 */
@Entity
@Table(name = "error_codes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Code d'erreur affiché (ex: F21, E3, etc.) */
    @Column(nullable = false)
    private String code;

    /** Marque associée */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    /** Type d'appareil concerné */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplianceType applianceType;

    /** Description courte du problème */
    @Column(nullable = false)
    private String shortDescription;

    /** Description détaillée du problème */
    @Column(columnDefinition = "TEXT")
    private String fullDescription;

    /** Causes possibles du problème */
    @Column(columnDefinition = "TEXT")
    private String possibleCauses;

    /** Étapes de diagnostic recommandées */
    @Column(columnDefinition = "TEXT")
    private String diagnosticSteps;

    /** Pièces potentiellement défaillantes */
    @Column(columnDefinition = "TEXT")
    private String potentialParts;

    /** Niveau de difficulté de réparation (1-5) */
    private Integer difficultyLevel;

    /** Temps estimé de réparation en minutes */
    private Integer estimatedRepairTime;

    /** Date de création */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Date de dernière mise à jour */
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
